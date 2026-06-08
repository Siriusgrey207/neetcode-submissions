class MinStack {
    List<Integer> list;
    List<Integer> listOfMinValues;

    public MinStack() {
        list = new ArrayList<>();
        listOfMinValues = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        int smallestVal;
        if (listOfMinValues.isEmpty()) {
            smallestVal = Integer.MAX_VALUE;
        } else {
            smallestVal = listOfMinValues.get(listOfMinValues.size() - 1);
        }
        listOfMinValues.add(Math.min(val, smallestVal));
    }
    
    public void pop() {
        // Remove the last element.
        int i = list.size() - 1;
        list.remove(i);
        listOfMinValues.remove(i);
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        return listOfMinValues.get(list.size() - 1);
    }
}
