package leetcode;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr ={1,2,5,7,8,9,10};

        System.out.println(search(arr,10));

    }



    public static int search(int[] nums, int target) {
        return bsearch(nums,0,nums.length-1,target);
    }

    public static int bsearch(int[] nums,int i,int j, int target){
        if(i==j){
            if(nums[i]==target){
                return i;
            }else{
                return -1;
            }
        }else{
            int mid = (i+j)/2;
            if(nums[mid]==target){
                return mid;
            }else{
                if(target>nums[mid]){
                    //go right
                    return bsearch(nums,mid+1,j,target);
                }else{
                    //go left
                    return bsearch(nums,i,mid,target);
                }
            }
        }
    }
}
