package strings;

/*
395. Longest Substring with At Least K Repeating Characters

Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

if no such substring exists, return 0.



Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.


Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 105
 */
public class ST_395_LongestSubstringWithKRepeatingChars {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }
    public int helper(String s, int st, int ed, int k){
        if(ed - st < k) return 0;
        int[] freq = new int[26];
        for(int i = st; i < ed; i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int mid = st; mid < ed; mid++){
            if(freq[s.charAt(mid)-'a'] < k){
                int next = mid + 1;
                while(next < ed && freq[s.charAt(next)-'a'] < k) next++;
                return Math.max(helper(s, st, mid, k), helper(s, next+1, ed, k));
            }
        }
        return ed - st;
    }

}
