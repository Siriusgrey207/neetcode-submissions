class StockSpanner {
    Stack<int[]> stack; // pair: daily stock price, span for that day and price

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    // Returns the span of the stock's price given today's price.
    public int next(int todaysPrice) {
        int[] todaysPair = new int[] { todaysPrice, 1 };

        if (stack.isEmpty()) { 
            stack.push(todaysPair); 
            return 1;
        }

        while (!stack.isEmpty() && todaysPrice >= stack.peek()[0]) {
            todaysPair[1] = todaysPair[1] + stack.pop()[1];
        }

        stack.push(todaysPair);
        return todaysPair[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */