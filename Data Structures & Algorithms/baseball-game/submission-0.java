class Solution {
    public int calPoints(String[] operations) {
        List<Integer> scores = new ArrayList<>();

        for (String operation : operations) {
            // "operation" is an integer
            if (!operation.equals("+") && !operation.equals("C") && !operation.equals("D")) {
                int num = Integer.parseInt(operation);
                scores.add(num);
            }

            // "add the last two entries"
            if (operation.equals("+")) {
                int lastElIndex = scores.size() - 1;
                int secondLastElIndex = lastElIndex - 1;

                int newScore = scores.get(lastElIndex) + scores.get(secondLastElIndex);
                scores.add(newScore);
            }

            // remove the last entry
            if (operation.equals("C")) {
                scores.remove(scores.size() - 1);
            }

            // double the last score and add it as a new entry in scores
            if (operation.equals("D")) {
                int lastEntry = scores.get(scores.size() - 1);
                int newEntry = 2 * lastEntry;
                scores.add(newEntry);
            }
        }

        int totalSum = 0;
        for (int score : scores) {
            totalSum += score;
        }

        return totalSum;
    }
}