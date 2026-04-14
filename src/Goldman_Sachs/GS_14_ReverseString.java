package Goldman_Sachs;

public class GS_14_ReverseString {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "abcde";
        String str3 = "";
        System.out.println(reverse(str1).equals("dcba"));
        System.out.println(reverse(str2).equals("edcba"));
        System.out.println(reverse(str3).equals(""));
    }
    public static String reverse1(String str){
        StringBuilder sb=  new StringBuilder(str);
        return sb.reverse().toString();
    }
    public static String reverse(String str){
        char[] arr = str.toCharArray();
        int st = 0, ed = arr.length-1;
        while(st < ed){
            char temp = arr[st];
            arr[st++] = arr[ed];
            arr[ed--] = temp;
        }
        return new String(arr);
    }
}
