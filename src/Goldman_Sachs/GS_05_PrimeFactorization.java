package Goldman_Sachs;

import java.io.*;
import java.util.*;

    /**
     * Return an array containing prime numbers whose product is x
     * Examples:
     * primeFactorization( 6 ) == [2,3]
     * primeFactorization( 5 ) == [5]
     */
public class GS_05_PrimeFactorization {
        public static List<Integer> primeFactorization(int x)
        {
            HashSet<Integer> result = new HashSet<>();
            if(x % 2 == 0){
                result.add(2);
                while(x % 2 == 0){
                    x /= 2;
                }
            }
            for(int i = 3; i * i <= x; i += 2){
                if(x % i == 0){
                    result.add(i);
                    while(x % i == 0){
                        x /= i;
                    }
                }
            }
            if(x != 1){
                result.add(x);
            }
            return result.stream().toList();
        }

        public static void main(String args[])
        {

            System.out.println(primeFactorization(6) + " " + primeFactorization(5));
            if(primeFactorization(6).equals(Arrays.asList(2,3))
                    &&
                    primeFactorization(5).equals(Arrays.asList(5))
            ) {
                System.out.println("All passed");
            }else {
                System.out.println("Failed");
            }

        }
}
