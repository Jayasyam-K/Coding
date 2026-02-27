class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int m = 0;
        for(char c : s.toCharArray()) if(c == '0'){ 
            m++;
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);
        TreeSet<Integer>[] nodeSets = new TreeSet[]{new TreeSet<>(),new TreeSet<>()};

        for(int i=0;i<=n;i++){
            nodeSets[i%2].add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(m);
        dist[m] = 0;
        nodeSets[m%2].remove(m);

        while(!q.isEmpty()){
            int curr = q.poll();
            int c1 = Math.max(k-n+curr,0);
            int c2 = Math.min(curr,k);
            int leftNode = curr + k-2*c2;
            int rightNode = curr + k-2*c1;
            int parity = leftNode % 2;

            SortedSet<Integer> sub = nodeSets[parity].subSet(leftNode,true,rightNode,true);
            List<Integer> toRemove = new ArrayList<>(sub);
            for(int m2: toRemove){
                dist[m2] = dist[curr] + 1;
                q.offer(m2);
                nodeSets[parity].remove(m2);
            }
        }
        return dist[0];
    }
}