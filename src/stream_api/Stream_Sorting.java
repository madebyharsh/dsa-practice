package stream_api;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream_Sorting {

    public static void main(String[] args) {
        //sort map
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Harsh", 42);
        map.put("Joyce", 52);
        map.put("Noel", 72);
        map.put("Jessica", 32);
        map.put("Cameron", 432);
        map.put("Paul", 3);
        Map<String, Integer> sortedMap = map.entrySet()
                .stream()
                // 1 .sorted((e1, e2)->e1.getValue()-e2.getValue())
                // 2 .sorted(Map.Entry.comparingByValue())
                // 3
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2)->e1, LinkedHashMap::new));
        System.out.println(sortedMap.toString());
    }
}
