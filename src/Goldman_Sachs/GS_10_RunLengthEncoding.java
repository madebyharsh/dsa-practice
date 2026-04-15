package Goldman_Sachs;
/*
 * Implement a run length encoding function.
 * For a string input the function returns output encoded as follows:
 *
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 * "aabbbaaabababab"  ->  "a2b3a3b1a1b1a1b1a1b1"
 */


import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class GS_10_RunLengthEncoding {

    public static String rle2(String input) {
        // Your code goes here
        StringBuilder sb=  new StringBuilder();
        input.chars().mapToObj(e->(char) e)
                .collect(Collectors.groupingBy(e->e, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .map(e-> "" + e.getKey() + e.getValue()).forEach(e->sb.append(e));
        return sb.toString();
    }
    public static String rle(String str){
        if(str.length() == 0) return "";
        int ind = 0;
        StringBuilder sb = new StringBuilder();
        while(ind < str.length()){
            char c = str.charAt(ind++);
            int count = 1;
            while(ind < str.length() && str.charAt(ind) == c) {
                ind++;
                count++;
            }
            sb.append(""+c+count);
        }
        return sb.toString();
    }


    public static void main(String[] args)  {

        if("".equals(rle("")) &&
                "a1".equals(rle("a")) &&
                "a3".equals(rle("aaa"))){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
    }
}

