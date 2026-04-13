package math;

public class MT_50_Pow {
    // Brute Force
    public double myPowBrute(double x, int n) {
        double result = 1.0;
        long exp = Math.abs((long) n);

        for (long i = 0; i < exp; i++) {
            result *= x;
        }

        return n < 0 ? 1.0 / result : result;
    }

    // Binary Exponentiation (Optimal)
    public double myPow(double x, int n) {
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        return pow(x, n);
    }
    public double pow(double x, int n){
        if(n == 0) return 1;
        double half = pow(x, n/2);
        if(n % 2 == 0) return half * half;
        else return half * half * x;
    }

}
