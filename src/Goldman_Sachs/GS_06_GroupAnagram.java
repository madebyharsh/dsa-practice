package Goldman_Sachs;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*
 * This program prints set of anagrams together in given string
 *
 * eg.
 * setOfAnagrams("cat dog tac sat tas god dog") should print "cat tac dog god dog sat tas"
 *
 */

public class GS_06_GroupAnagram {

    static String input = "cat dog tac sat tas god dog";

    static void setOfAnagrams(String inputString){

        HashMap<String, List<String>> map = new HashMap<>();
        for(String word: inputString.split(" ")){
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            String str = new String(wordArr);
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(word);
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            result.add(entry.getValue());
        }
        System.out.println(result);
    }


    public static void main(String[] args) {

        String input = "cat dog tac sat tas god dog";
        setOfAnagrams(input);

    }
}
