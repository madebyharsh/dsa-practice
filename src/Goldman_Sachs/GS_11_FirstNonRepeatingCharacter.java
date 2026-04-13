package Goldman_Sachs;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GS_11_FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        // 1. Simple case
        System.out.println(findFirstNonRepeatingCharacter("aabccdeffg") == 'b'); // b

        // 2. First char is unique
        System.out.println(findFirstNonRepeatingCharacter("abcabcde") == 'd'); // d

        // 3. All repeating except last
        System.out.println(findFirstNonRepeatingCharacter("aabbccd") == 'd'); // d

        // 4. All characters repeating
        System.out.println(findFirstNonRepeatingCharacter("aabbcc") == ' ') ; // (depends: return ' ' or similar)

        // 5. Single character
        System.out.println(findFirstNonRepeatingCharacter("z") == 'z'); // z

        // 6. Empty string (edge case)
        System.out.println(findFirstNonRepeatingCharacter("") == ' '); // ' ' or error handling

        // 7. Mixed case sensitivity
        System.out.println(findFirstNonRepeatingCharacter("aAbBcCdD") == 'a'); // a (if case-sensitive)

        // 8. First unique in middle
        System.out.println(findFirstNonRepeatingCharacter("xxyyzzabc") == 'a'); // a

        // 9. Long repeating prefix
        System.out.println(findFirstNonRepeatingCharacter("aaabbbcccdeff") == 'd'); // d

        // 10. Random order
        System.out.println(findFirstNonRepeatingCharacter("swiss") == 'w'); // w
    }

    public static char findFirstNonRepeatingCharacter(String str){
        // First way without storing it - Optimal
        return str.chars().mapToObj(e->(char) e)
                .filter(e->str.indexOf(e) == str.lastIndexOf(e))
                .findFirst()
                .orElse(' ');
        // Second way with HashMap value stored - Not Optimal
        /*
        return str.chars().mapToObj(e->(char) e)
                .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue() == 1)
                .map(e->e.getKey())
                .findFirst()
                .orElse(' ');
         */
    }
}
