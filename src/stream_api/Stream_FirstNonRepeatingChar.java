package stream_api;

public class Stream_FirstNonRepeatingChar {
    public static void main(String[] args) {
        String str = "abcdabcddeabcdgjjjk";
        System.out.println(
                str.chars().mapToObj(e-> (char) e)
                .filter(e-> str.indexOf(e) == str.lastIndexOf(e))
                        .findFirst()
                        .orElse('0')
        );
    }
}
