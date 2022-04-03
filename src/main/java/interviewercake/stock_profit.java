package interviewercake;

public class stock_profit {

    public static void main(String[] args) {
        int stockPrices[] = {10, 7, 5, 8, 11, 9};
        int result = getMaxProfit(stockPrices);
        System.out.println("result: " + result);
    }

    public static int getMaxProfit(int stockPrices[]) {
        int min = stockPrices[0];
        int maxProfit = 0;
        for (int i = 1; i < stockPrices.length; i++) {
            if (min > stockPrices[i]) {
                min = stockPrices[i];
            }
            int currentProfit = stockPrices[i] - min;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }
}
