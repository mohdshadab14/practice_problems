package leetcode;

//238. Product of Array Except Self

public class ProductExceptSelf {

    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5};
        int arr2[] = productExceptSelf(arr);
        for(int i: arr2){
            System.out.println(i);
        }
    }

    public static int[] productExceptSelf(int[] nums) {

        int zeroCounts = 0;
        int product = 1;
        int zeroIndex = -1;
        for(int i=0;i<nums.length;i++){
            if(i!=0){
                product*=i;
            }else{
                zeroIndex = i;
                zeroCounts++;
            }
        }

        if(zeroCounts==0){
            for(int i=0;i<nums.length;i++){
                nums[i]=product/nums[i];
            }
        }else if(zeroCounts==1){
            for(int i=0;i<nums.length;i++){
                if(i==zeroIndex){
                    nums[i]=product;
                }else{
                    nums[i] = 0;
                }
            }
        }else{
            for(int i=0;i<nums.length;i++){
                nums[i]=0;
            }
        }

        return nums;

    }



}
