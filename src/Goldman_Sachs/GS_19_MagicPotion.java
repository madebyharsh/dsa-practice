package Goldman_Sachs;

import java.util.Arrays;

/*
Combine ingredients in a specific order, any of which may be repeated.
Encoding format: introduce * to indicate "repeat from beginning".

Implement a function that takes as input an un-encoded potion and returns the minimum number of characters required to encode

Example Test Case:
Input: ABABCABABCE
Output: 6
Explanation:
In the first part, ABAB,
AB has repeated twice and it can be replaced as AB* and
similarly ABABC is repeated twice and so it can be encoded as AB*C*.
The last character is placed as it is
and the final encoded format would be AB*C*E and so the length of the minimum encoded string is 6.
 */
public class GS_19_MagicPotion {
    public static void main(String[] args) {
        System.out.println(minimalSteps("ABABCABABCE") == 6);
        System.out.println(minimalSteps("ABCDABCE") == 8);
        System.out.println(minimalSteps("ABCABCE") == 5);
        System.out.println(minimalSteps("AAA") == 3);
        System.out.println(minimalSteps("AAAA") == 3);
        System.out.println(minimalSteps("BBB") == 3);
        System.out.println(minimalSteps("AAAAAA") == 4);
    }
    private static int minimalSteps(String ingredients) {
        int n = ingredients.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // Check repeat only for even number of characters (odd index)
            if (i % 2 == 1 && (repeatString(ingredients, 0, i / 2, i))) {
                // If repeated use the length of the first block + 1 (for *)
                dp[i] = dp[i / 2] + 1;
            } else {
                // If not just increment
                dp[i] = dp[i-1] + 1;
            }
        }
        return dp[n-1];
    }
    private static boolean repeatString(String s, int i, int j, int k) {
        return s.substring(i, j+1).equals(s.substring(j+1, k+1));
    }
}
