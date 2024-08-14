package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class BestTimeToBuyAndSellStocks {

    public static void main(String[] args) {
        int arr[] = { 7,1,5,3,6,4};

        int profit = maxProfit(arr);
        System.out.println(profit);
    }

    public static int maxProfit(int[] prices) {
            int maxProfit = 0;
            int buyingTime=0;
            for(int i=0;i<prices.length-1;i++){
                int sellingTime = i+1;
                int profit= prices[sellingTime] - prices[buyingTime];
                if(profit>maxProfit){
                    maxProfit = profit;
                }else{
                    if(prices[buyingTime]>prices[sellingTime]){
                        buyingTime = sellingTime;
                    }
                }
            }
            return maxProfit;
    }
}
