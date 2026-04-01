class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++)
            indices[i] = i;
        Arrays.sort(indices, (a, b) -> Integer.compare(positions[a], positions[b]));

        Stack<Integer> stack = new Stack<>();
        for (int curr : indices) {
            if (directions.charAt(curr) == 'R') {
                stack.push(curr);
            } else {
                while (!stack.isEmpty() && healths[curr] > 0) {
                    int top = stack.pop();
                    if (healths[top] > healths[curr]) {
                        healths[top] -= 1;
                        healths[curr] = 0;
                        stack.push(top);
                    } else if (healths[top] < healths[curr]) {
                        healths[curr] -= 1;
                        healths[top] = 0;
                    } else {
                        healths[curr] = 0;
                        healths[top] = 0;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int h : healths)
            if (h > 0)
                result.add(h);
        return result;
    }
}