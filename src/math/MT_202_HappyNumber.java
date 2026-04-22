package math;

import java.util.HashSet;

public class MT_202_HappyNumber {
    // floyd's cycle detection
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(true){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            System.out.println(slow);
            if(slow == 1) return true;
            if(slow == fast) return false;
        }
    }
    public int getNext(int num){
        int next = 0;
        while(num != 0){
            int digit = num % 10;
            num /= 10;
            next += digit * digit;
        }
        return next;
    }
    // Using HashSet
    public boolean isHappyByHashSet(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

}
