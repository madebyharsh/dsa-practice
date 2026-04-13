package arrays;

public class AR_3896_AlternatingPrime {

public int minOperations(int[] nums) {
    int count = 0;
    for(int i = 0; i < nums.length; i++){
        // prime required
        int val = nums[i];
        if(i % 2 == 0){
            while(!isPrime(val)){
                val++;
                count++;
            }
        } else{
            // non-prime required;
            while(isPrime(val)){
                val++;
                count++;
            }
        }
    }
    return count;
}
public boolean isPrime(int num){
    if(num <= 1) return false;
    if(num == 2) return true;
    if(num % 2 == 0) return false;
    for(int i = 3; i * i <= num; i += 2){
        if(num % i == 0) return false;
    }
    return true;
}
}
