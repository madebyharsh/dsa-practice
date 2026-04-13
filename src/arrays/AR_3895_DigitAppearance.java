package arrays;

public class AR_3895_DigitAppearance {
    // Brute Force
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for(int num: nums){
            int value = num;
            while(value != 0){
                int rem = value % 10;
                value /= 10;
                if(rem == digit){
                    count++;
                }
            }
        }
        return count;
    }

    // Digit Position / Mathematical Counting (Optimal)
    public static int countDigitOptimal(int n, int digit) {
        int count = 0;

        for (long factor = 1; factor <= n; factor *= 10) {
            long lower = n % factor;
            long curr = (n / factor) % 10;
            long higher = n / (factor * 10);
            if (curr < digit) {
                count += higher * factor;
            } else if (curr == digit) {
                count += higher * factor + (lower + 1);
            } else {
                count += (higher + 1) * factor;
            }
            // Special handling for digit = 0 (important edge case)
            if (digit == 0) {
                count -= factor;
            }
        }
        return count;
    }


}
