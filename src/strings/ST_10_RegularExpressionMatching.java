package strings;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ST_10_RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("ab", "a*"));
    }
    public static boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.matches());
        return false;
    }
}
