package strings;

/*A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.



Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false


Constraints:

1 <= sentence.length <= 1000
sentence consists of lowercase English letters. */

public class ST_Pangram {
    public boolean checkIfPangram1(String sentence) {
        int[] chars = new int[26];
        for(char c: sentence.toCharArray()){
            chars[c-'a']++;
        }
        for(int freq: chars){
            if(freq == 0) return false;
        }
        return true;
    }

    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26){
            return false;
        }

        for(char i = 'a'; i <= 'z'; i++){
            if(!sentence.contains(String.valueOf(i))){
                return false;
            }
        }
        return true;
    }

}
