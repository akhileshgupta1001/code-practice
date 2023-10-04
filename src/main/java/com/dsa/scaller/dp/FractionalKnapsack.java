package com.dsa.scaller.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FractionalKnapsack {
    public static double fractionalKnapsack(int capacity, List<Item> items) {
        // Sort items by value-to-weight ratio in descending order
        Collections.sort(items, (item1, item2) -> {
            double ratio1 = (double) item1.value / item1.weight;
            double ratio2 = (double) item2.value / item2.weight;
            return Double.compare(ratio2, ratio1);
        });

        double totalValue = 0.0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                // Take the whole item
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                // Take a fraction of the item
                int remainingWeight = capacity - currentWeight;
                double fraction = (double) remainingWeight / item.weight;
                totalValue += fraction * item.value;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        //[16,3,3,6,7,8,17,13,7]
        //[3,10,9,18,17,17,6,16,13]
        //11
        int capacity = 11;
        List<Item> items = new ArrayList<>();
        items.add(new Item(3, 16));
        items.add(new Item(10, 3));
        items.add(new Item(9, 3));
        items.add(new Item(18, 6));
        items.add(new Item(17, 7));
        items.add(new Item(17, 8));
        items.add(new Item(6, 17));
        items.add(new Item(16, 13));
        items.add(new Item(13, 7));


        double maxValue = fractionalKnapsack(capacity, items);
        System.out.println("Maximum value achievable: " + maxValue);
    }
}

