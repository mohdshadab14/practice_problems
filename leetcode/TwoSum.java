package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int [] num = {-1,-2,-3,-4,-5};
        int[] result = twoSum(num,-8);
        for(int i:result){
            System.out.println(i);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                result[0]=i;
                result[1]=map.get(complement);
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
