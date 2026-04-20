package strings;

public class ST_415_AddStrings {
    public String addStrings(String num1, String num2) {
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
