package divide_and_conquer;

public class StraigtMinMax {

    public static class MinMax{
        int min;
        int max;
    }

    public MinMax getMinMax(int[] arr){
        MinMax minMax = new MinMax();
        minMax.min = arr[0];
        minMax.max = arr[0];

        //
        for(int i=0;i<arr.length;i++){
            if(arr[i]<minMax.min){
                minMax.min = arr[i];
            }else if(arr[i]>minMax.max){
                minMax.max = arr[i];
            }
        }

        return minMax;
    }
}
