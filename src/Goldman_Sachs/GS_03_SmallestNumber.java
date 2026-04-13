package Goldman_Sachs;

/*
 * public static int FindMin(int a[])
 * Returns the smallest number in array that has been rotated
 * For example - Array {3,4,5,6,1,2} returns 1
 */
public class GS_03_SmallestNumber {
    public static void main(String[] args) {
        boolean result = true;
        result = result && FindMin(new int[]{3,4,5,6,1,2}) == 1;
        result = result && FindMin(new int[]{2,1}) == 1;
        result = result && FindMin(new int[]{1}) == 1;
        System.out.println(result);
        try {
            FindMin(null);
            result = false;

            System.out.println(result + " In Try Block");
        }
        catch(Exception e)
        {
            result = result && true;
            System.out.println(result + " In Catch Block");
        }

    }

    private static int FindMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int min = Integer.MAX_VALUE;
        for(int num: nums){
            if(min > num){
                min = num;
            }
        }
        return min;
    }
}
