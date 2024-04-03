package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.PrintWriter;


public class FunctionSystem {
    private final LogFunction logF;

    private final TrigonometricFunction trF;

    public FunctionSystem(LogFunction logF, TrigonometricFunction trF) {
        this.logF = logF;
        this.trF = trF;
    }

    public double calculate(double x) {
        if (x <= 0) {
            return (((((trF.sec(x) + trF.sin(x)) + (trF.tan(x) + trF.sin(x))) + ((trF.cos(x) * trF.cos(x) * trF.cos(x)) + trF.tan(x))) + trF.cos(x)) + trF.cos(x));
        } else {
            return (((((logF.log(x, 10) * logF.log(x, 10) * logF.log(x, 10)) - (logF.log(x, 5) / logF.ln(x))) *
                    ((logF.log(x, 10) * logF.log(x, 10) * logF.log(x, 10)) - (logF.log(x, 5) / logF.ln(x))) *
                    ((logF.log(x, 10) * logF.log(x, 10) * logF.log(x, 10)) - (logF.log(x, 5) / logF.ln(x)))) *
                    (((logF.log(x, 10) + logF.ln(x)) * (logF.log(x, 10) + logF.ln(x))) * logF.ln(x)))
                    - ((logF.ln(x)) / logF.log(x, 3)) / logF.log(x, 2));
        }
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
