package divide_and_conquer;

public class BinarySearch {

    public int binarySearch(int[] arr,int i,int j,int k){
        if(i==j){
            if(arr[i]==k){
                return i;
            }else{
                return -1;
            }
        }else{
            int mid = (i+j)/2;

            if(arr[mid]==k){
                return mid;
            }else{
                if(k<arr[mid]){
                    return binarySearch(arr,i,mid,k);
                }else{
                    return binarySearch(arr,mid+1,j,k);
                }
            }
        }
    }
}
