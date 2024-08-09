package greedy;

import java.awt.event.KeyAdapter;
import java.util.*;

public class KnapsackProblem implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Knapsack k1 = (Knapsack) o1;
        Knapsack k2 = (Knapsack) o2;
        Double perUnitProfit_a = (double) (k1.profit/k1.weight);
        Double perUnitProfit_b = (double) (k2.profit/k2.weight);
        return perUnitProfit_b.compareTo(perUnitProfit_a);
    }

    public static class Knapsack{
        double profit;
        double weight;

        Knapsack(double profit, double weight){
            this.profit = profit;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Knapsack k1 = new Knapsack(25,18);
        Knapsack k2 = new Knapsack(24,15);
        Knapsack k3 = new Knapsack(15,10);

        ArrayList<Knapsack> knapsackArrayList = new ArrayList<>();
        knapsackArrayList.add(k1);
        knapsackArrayList.add(k2);
        knapsackArrayList.add(k3);

        int maxBagSize = 20;

        double maximumProfit = greedyKnapsack(knapsackArrayList,maxBagSize);

        System.out.println(maximumProfit);
    }

    private static double greedyKnapsack(ArrayList<Knapsack> knapsackArrayList,double maxBagSize) {
        Comparator comparator = new KnapsackProblem();
        Collections.sort(knapsackArrayList,comparator);
        for(Knapsack k:knapsackArrayList){
            System.out.println(k.weight);
        }
        double maxProfit = 0;

        while(maxBagSize>0){
            Knapsack k =knapsackArrayList.get(0);
            if(k.weight<maxBagSize){
                maxBagSize=maxBagSize-k.weight;
                maxProfit = maxProfit+k.profit;
                knapsackArrayList.remove(k);
            }else{
                double profit = maxBagSize*(k.profit/ k.weight);
                maxProfit = maxProfit+profit;
                maxBagSize = maxBagSize -maxBagSize;
            }
        }
        return maxProfit;
    }

}
