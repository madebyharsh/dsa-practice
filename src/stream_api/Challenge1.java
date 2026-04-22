package stream_api;

import java.util.*;
import java.util.stream.Collectors;

public class Challenge1 {
    public static void main(String[] args) {
        // given a list of integers, return top 3 frequent elements. if frequencies
        // are equal, prefer smaller number;
        List<Integer> list = Arrays.asList(1,1,2,3,3,3,2,43,3,4,4,5,45,5,6,6,6,6,343,345445,45,45, 4,45, 4454,4,54, 54,45, 45,45);
        System.out.println(
                list.stream()
                        .collect(
                                Collectors.groupingBy(
                                        e->e,
                                        LinkedHashMap::new,
                                        Collectors.counting()))
                        .entrySet().stream()
                        .sorted(new Comparator<Map.Entry<Integer, Long>>() {
                            @Override
                            public int compare(Map.Entry<Integer, Long> o1, Map.Entry<Integer, Long> o2) {
                                int freqCompare = Long.compare(o2.getValue(), o1.getValue());
                                return freqCompare != 0 ? freqCompare : o1.getKey() - o2.getKey();
                            }
                        })
                        .limit(3)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new))
                        .toString()
        );
    }
}
