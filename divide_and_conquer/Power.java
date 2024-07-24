package divide_and_conquer;

public class Power {

    public int getPowerOfAnElement(int a,int n){
        int result = 1;
        for(int i=0;i<n;i++){
            result = result*a;
        }
        return result;
    }
}
