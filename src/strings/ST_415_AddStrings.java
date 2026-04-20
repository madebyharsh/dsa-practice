package strings;

public class ST_415_AddStrings {
    public String addStrings2(String num1, String num2) {
        int n = Math.max(num1.length(), num2.length());
        char[] arr = new char[n + 1];
        int carry = 0, i = num1.length()-1, j = num2.length()-1, k = n;
        while(k >= 0){
            int a = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;
            arr[k--] = (char) ('0' + sum);
        }
        return arr[0] == '0' ? new String(arr, 1, n) : new String(arr);
    }

    public String addStrings1(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int ind1 = num1.length()-1, ind2 = num2.length()-1;
        while(ind1 >= 0 || ind2 >=0 || carry != 0){
            int a = 0, b = 0;
            if(ind1 >= 0){
                a = num1.charAt(ind1--) - '0';
            }
            if(ind2 >= 0){
                b = num2.charAt(ind2--) - '0';
            }
            System.out.printf("a = %d, b = %d\n", a, b);
            int sum = a + b + carry;
            carry = sum / 10;
            sum %= 10;
            sb.append(sum);
        }
        return sb.reverse().toString();
    }
}
