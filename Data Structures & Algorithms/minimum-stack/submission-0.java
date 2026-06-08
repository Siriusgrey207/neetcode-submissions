class MinStack {
    List<Integer> list;
    int currentMinValue = Integer.MAX_VALUE;

    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        currentMinValue = Math.min(val, currentMinValue);
    }
    
    public void pop() {
        // Remove the last element.
        int i = list.size() - 1;
        int lastEl = list.get(i);
        list.remove(i);

        // If the smallest element has just been removed, find the new smallest one
        if (currentMinValue == lastEl) {
            currentMinValue = Integer.MAX_VALUE;
            for (int el : list) {
                currentMinValue = Math.min(el, currentMinValue);
            }
        }
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        return currentMinValue;
    }
}
