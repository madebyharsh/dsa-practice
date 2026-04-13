package Goldman_Sachs;

public class GS_04_SecondSmallest {
    public static void main(String[] args) {
        System.out.println(findSecondSmallest(new int[]{2, 3, 4, 4, 5, 3, 2}) == 3);
        System.out.println(findSecondSmallest(new int[]{2, 3, -1, 1, 4, 4, 5, 3, 2}) == 1);
        System.out.println(findSecondSmallest(new int[]{2, 0, 1, 3, 4, 4, 5, 3, 2}) == 1);
        System.out.println(findSecondSmallest(new int[]{2}) == 2);
        System.out.println(findSecondSmallest(new int[]{}) == -1);
    }
    public static int findSecondSmallest(int[] arr){
        if(arr == null || arr.length == 0) return -1;
        if(arr.length < 2) return arr[0];
        int small = Integer.MAX_VALUE, smallest = Integer.MAX_VALUE;
        for(int num: arr){
            if(small > num){
                smallest = small;
                small = num;
            } else if(small != num && smallest > num){
                smallest = num;
            }
        }
        return smallest;
    }
}
