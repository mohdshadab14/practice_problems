package divide_and_conquer;

public class DACMinMax {
    public static class MinMax{
        int min;
        int max;
    }

    public DACMinMax.MinMax getMinMax(int[] arr,int start,int end) {
        MinMax minMax = new MinMax();
        MinMax l_minMax = new MinMax();
        MinMax r_minMax = new MinMax();


        if (start == end) {
            minMax.min = arr[start];
            minMax.max = arr[start];
            //display(minMax);
            return minMax;
        } else if (start == end - 1) {
            if (arr[start] < arr[end]) {
                minMax.min = arr[start];
                minMax.max = arr[end];
            } else {
                minMax.min = arr[end];
                minMax.max = arr[start];
            }
            //display(minMax);
            return minMax;
        } else {

            int mid = (start + end) / 2;
            l_minMax = getMinMax(arr, start, mid);
            r_minMax = getMinMax(arr, mid + 1, end);

            if(l_minMax.min<r_minMax.min){
                minMax.min = l_minMax.min;
            }else{
                    minMax.min = r_minMax.min;
            }
            if(l_minMax.max>r_minMax.max){
                minMax.max = l_minMax.max;
            }else {
                minMax.max = r_minMax.max;
            }
            //display(minMax);
            return minMax;
        }
    }
    public void display(MinMax minMax){
        System.out.println(minMax.min+" "+minMax.max);
    }

}
