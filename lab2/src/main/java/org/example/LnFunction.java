package org.example;

import lombok.NoArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.PrintWriter;

@NoArgsConstructor
public class LnFunction {
    private final double eps = 0.00000001;


    public double calculate(double arg) {
        if (arg == 0) return Double.NEGATIVE_INFINITY;
        if (Double.isInfinite(arg)) return Double.POSITIVE_INFINITY;
        if (Double.isNaN(arg) || arg < 0) return Double.NaN;
        double x = (arg - 1) / (arg + 1);
        double result = 0;
        double previous = 0;
        double current = Double.MAX_VALUE;
        int n = 1;
        while (Math.abs(current - previous) >= eps) {
            previous = current;
            current = n % 2 == 0 ? 0 : 2 * Math.pow(x, n) / n;
            result += current;
            n++;
        }
        return result;
    }

    public void writeCSV(double x, PrintWriter out) {
        double res = calculate(x);
        try {
            CSVFormat csvFormat = CSVFormat.DEFAULT.withDelimiter(',');
            CSVPrinter printer = new CSVPrinter(out, csvFormat);
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
