class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) 
    {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) 
        {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        List<Integer> res = new ArrayList<>();

        for (int ind : queries) 
        {
            int val = nums[ind];
            List<Integer> pos = map.get(val);

            if (pos.size() == 1) 
            {
                res.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(pos, ind);

            int left = pos.get((idx - 1 + pos.size()) % pos.size());
            int right = pos.get((idx + 1) % pos.size());

            int d1 = Math.abs(ind - left);
            int d2 = Math.abs(ind - right);

            d1 = Math.min(d1, n - d1);
            d2 = Math.min(d2, n - d2);

            res.add(Math.min(d1, d2));
        }

        return res;
    }
}