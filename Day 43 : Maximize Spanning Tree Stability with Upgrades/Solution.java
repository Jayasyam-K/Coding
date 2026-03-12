class Solution {
    class Edge {
        int src, dest, strength;
        boolean must;
        
        Edge(int src, int dest, int strength, boolean must) {
            this.src = src;
            this.dest = dest;
            this.strength = strength;
            this.must = must;
        }
    }
    
    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];  
        }

        void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            
            if (rootX == rootY) return;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        List<Edge> mandatory = new ArrayList<>();
        List<Edge> optional = new ArrayList<>();
        
        for (int[] edgeData : edges) {	
            Edge edge = new Edge(edgeData[0], edgeData[1], edgeData[2], edgeData[3] == 1);
            if (edge.must) {
                mandatory.add(edge);
            } else {
                optional.add(edge);
            }
        }
    
        DSU dsu = new DSU(n);
        
        for (Edge e : mandatory) {
            if (dsu.find(e.src) == dsu.find(e.dest)) {
                return -1;
            }
            dsu.union(e.src, e.dest);
        }
        
        int[] parent_snap = new int[n];
        int[] rank_snap = new int[n];
        for (int i = 0; i < n; i++) {
            parent_snap[i] = dsu.parent[i];
            rank_snap[i] = dsu.rank[i];
        }
        
        int left = 1;
        int right = 0;
        for (int[] e : edges) {
            right = Math.max(right, e[2] * 2);
        }

        int bestStability = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canAchieve(n, mandatory, optional, k, mid, parent_snap, rank_snap)) {
                bestStability = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bestStability;
    }

    private boolean canAchieve(int n, List<Edge> mandatory, List<Edge> optional, 
                               int k, int minStability, int[] parent_snap, int[] rank_snap) {
        DSU dsu = new DSU(n);
        dsu.parent = parent_snap.clone();
        dsu.rank = rank_snap.clone();

        for (Edge e : mandatory) {
            if (e.strength < minStability) {
                return false;
            }
        }

        List<Edge> directCandidates = new ArrayList<>();
        List<Edge> upgradeCandidates = new ArrayList<>();

        for (Edge e : optional) {
            if (e.strength >= minStability) {
                directCandidates.add(e);
            } else if (e.strength * 2 >= minStability) {
                upgradeCandidates.add(e);
            }
        }

        for (Edge e : directCandidates) {
            if (dsu.find(e.src) != dsu.find(e.dest)) {
                dsu.union(e.src, e.dest);
            }
        }
        
        int upgradesUsed = 0;
        for (Edge e : upgradeCandidates) {
            if (upgradesUsed >= k) break;
            
            if (dsu.find(e.src) != dsu.find(e.dest)) {
                dsu.union(e.src, e.dest);
                upgradesUsed++;
            }
        }
        
        int root = dsu.find(0);
        for (int i = 1; i < n; i++) {
            if (dsu.find(i) != root) return false;
        }
        
        return true;
    }
}