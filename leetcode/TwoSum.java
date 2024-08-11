package leetcode;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int [] num = {-1,-2,-3,-4,-5};
        int[] result = twoSum(num,-8);
        for(int i:result){
            System.out.println(i);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int num1 = 0;
        int num2 = 0;
        int i=0;
        int j=arr.length-1;
        int[] result = new int[2];
        while(i<j){
                if(arr[i]+arr[j]==target){
                    num1 = arr[i];
                    num2 = arr[j];
                    break;
                }else if(arr[i]+arr[j]>target){
                    j--;
                }else if(arr[i]+arr[j]<target){
                    i++;
                }
        }
        int end=-1;
        for(int k=0;k<nums.length;k++){
            if(nums[k]==num1 || nums[k]==num2){
                result[0] = k;
                end = k;
                break;
            }
        }
        for(int k=end+1;k<nums.length;k++){
            if(nums[k]==num2 || nums[k]==num1){
                result[1] = k;
                break;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
