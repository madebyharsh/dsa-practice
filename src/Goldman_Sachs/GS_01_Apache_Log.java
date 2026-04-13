package Goldman_Sachs;

import java.util.*;

public class GS_01_Apache_Log {

    /**
     * Given a log file, return IP address(es) which accesses the site most often.
     */

    public static String findTopIpaddress(String[] lines) {
        if(lines == null || lines.length == 0) return "";
        HashMap<String, Integer> freq = new HashMap<>();
        int count = 0;
        String ip_result = "";
        for(String line: lines){
            String ip = line.substring(0, line.indexOf(" "));
            int currCount = freq.getOrDefault(ip, 0) + 1;
            freq.put(ip, currCount);
            if(currCount > count){
                ip_result = ip;
                count = currCount;
            }
        }
        return ip_result;
    }

    public static void main(String[] args) {

        String lines[] = new String[] {
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132"};
        String result = findTopIpaddress(lines);

        if (result.equals("10.0.0.1")) {
            System.out.println("Test passed");

        } else {
            System.out.println("Test failed");

        }

    }

}