package com.company.arrays;

public class BestTimeToBuyAndSellStocks {
    public void mainFn(int[] stockPriceArray) {
        int profit = 0;
        int arrayCounter =0;
        while (arrayCounter < stockPriceArray.length) {
            int purchaseIndex = findPurchaseIndex(stockPriceArray, arrayCounter);
            System.out.println("Purchase Rate: " + stockPriceArray[purchaseIndex]);
            arrayCounter = purchaseIndex + 1;
            int sellIndex = findSellIndex(stockPriceArray, arrayCounter);
            System.out.println("Sell Rate: " + stockPriceArray[sellIndex]);
            arrayCounter = sellIndex + 1;
        }
    }

    int findSellIndex(int[] stockPriceArray, int startIndex) {
        for (int i = startIndex; i< stockPriceArray.length; i++) {
            if ( (i+1) < stockPriceArray.length) {
                if (stockPriceArray[i+1] < stockPriceArray[i]) {
                    return i;
                }
            }
        }
        return stockPriceArray.length-1;
    }

    int findPurchaseIndex(int[] stockPriceArray, int startIndex) {
        for (int i = startIndex; i< stockPriceArray.length; i++) {
            if ( (i+1) < stockPriceArray.length-1) {
                if (stockPriceArray[i+1] > stockPriceArray[i]) {
                    return i;
                }
            }
        }
        return stockPriceArray.length-1;
    }
}
