class MinStack {
    List<Integer> values;
    List<Integer> smallestValues;

    public MinStack() {
        values = new ArrayList<>();
        smallestValues = new ArrayList<>();
    }
    
    public void push(int val) {
        values.add(val);
        int smallest;

        if (smallestValues.isEmpty()) {
            smallest = Integer.MAX_VALUE;
        } else {
            smallest = smallestValues.get(smallestValues.size() - 1);
        }

        smallest = Math.min(smallest, val);
        smallestValues.add(smallest);
    }
    
    public void pop() {
        values.remove(values.size() - 1);
        smallestValues.remove(smallestValues.size() - 1);
    }
    
    public int top() {
        return values.get(values.size() - 1);
    }
    
    public int getMin() {
        return smallestValues.get(smallestValues.size() - 1);
    }
}
