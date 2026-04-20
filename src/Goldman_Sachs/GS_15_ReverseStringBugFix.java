package Goldman_Sachs;
import java.io.*;
import java.util.*;

/**
 * public static String reverseStr( String str )
 * Example: reverseStr(str) where str is "abcd" returns "dcba".
 */
public class GS_15_ReverseStringBugFix {

    public static String reverseStr( String str ){
        // using StringBuilder class
//        return new StringBuilder(str).reverse().toString();
//        using char array
        /*
        char[] arr = str.toCharArray();
        int st = 0, ed = arr.length-1;
        while(st < ed){
            char temp = arr[st];
            arr[st++] = arr[ed];
            arr[ed--] = temp;
        }
        return new String(arr);

         */
        return str.chars().mapToObj(e-> (char) e).sorted(Comparator.reverseOrder()).toString();


    };


    public static void main(String[] args){

        String testString;
        String solution;
        boolean result = true;

        result = result && reverseStr("abcd").equals("dcba");

        if(result){
            System.out.println("All tests pass");
        }
        else{
            System.out.println("There are test failures");
        }

    }
}
