package task1;

public class Function {


    public static double arctg(double x) {
        if (Math.abs(x) > 1) {
            throw new IllegalArgumentException("invalid X value");
        }
        double eps = 1e-6;
        double prev = x;
        double result = x;
        double cur = Math.PI / 2 + 1;
        int i = 1;
        while (Math.abs(cur - prev) > eps) {
            prev = cur;
            cur = Math.pow(-1, i) / (2 * i + 1) * Math.pow(x, 2 * i + 1);
            result += cur;
            i++;
        }
        return result;
    }

}
