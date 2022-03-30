package interviewercake;

public class stock_profit {

    public static void main(String[] args) {
        int stockPrices[] = {10, 7, 5, 8, 11, 9};
        int result = getMaxProfit(stockPrices);
        System.out.println("result: " + result);
    }

    public static int getMaxProfit(int stockPrices[]) {
        int min = stockPrices[0];
        int max = stockPrices[1];
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        for (int i = 2; i < stockPrices.length; i++) {
            if (stockPrices[i] < min) {
                min = stockPrices[i];
            } else if (stockPrices[i] > max) {
                max = stockPrices[i];
            }
        }
        return max - min;
    }
}
