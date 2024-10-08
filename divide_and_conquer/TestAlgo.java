package divide_and_conquer;

import java.time.Instant;

public class TestAlgo {
    public static void main(String[] args) {


        //minmaxtest();

        //powerofelementtest();

        searchtest();

    }

    private static void searchtest() {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        LinearSearch linearSearch = new LinearSearch();
        int index;
        index = linearSearch.search(arr,10);
        System.out.println(index);
        BinarySearch binarySearch = new BinarySearch();
        index = binarySearch.binarySearch(arr,0,arr.length-1,10);
        System.out.println(index);
    }

    private static void powerofelementtest() {

        int a=2;
        int n=7;

        System.out.println((new Power()).getPowerOfAnElement(a,n));

        System.out.println((new PowerDAC()).getPowerOfAnElement(a,n));

    }

    private static void minmaxtest() {
        int[] arr = {10,9,8,7,6,1,2,3,4,5,29,25,22,100,0,-10,300,50};
        long startTime,endTime;
        startTime= Instant.now().toEpochMilli();
        StraigtMinMax straigtMinMax = new StraigtMinMax();
        StraigtMinMax.MinMax minMax_straight = straigtMinMax.getMinMax(arr);
        endTime = Instant.now().toEpochMilli();
        System.out.println(startTime);
        System.out.println(endTime);
        long timeTaken = endTime-startTime;
        System.out.println("Time taken for straight min max "+ timeTaken);

        startTime = Instant.now().toEpochMilli();
        DACMinMax dacMinMax = new DACMinMax();
        DACMinMax.MinMax minMax_dac = dacMinMax.getMinMax(arr,0,arr.length-1);
        endTime = Instant.now().toEpochMilli();
        timeTaken = endTime-startTime;
        System.out.println("Time taken for dac min max "+timeTaken);

        System.out.println(minMax_straight.min+" "+minMax_straight.max);
        System.out.println(minMax_dac.min+" "+minMax_dac.max);
    }
}
