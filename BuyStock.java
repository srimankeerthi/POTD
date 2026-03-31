class BuyStock {
    public int maxProfit(int[] arr, int k) {
        int n = arr.length;
        
        if (n == 0) return 0;

        int hold = -arr[0]; // bought stock
        int cash = 0;       // no stock

        for (int i = 1; i < n; i++) {
            int prevCash = cash;

            // sell
            cash = Math.max(cash, hold + arr[i] - k);

            // buy
            hold = Math.max(hold, prevCash - arr[i]);
        }

        return cash;
    }
}