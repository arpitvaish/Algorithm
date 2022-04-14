
class disjointSet {

    public static void makeSet(int[] parent, int[] rank, int n) {

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int u, int[] parent) {

        if (parent[u] == u) {

            return u;
        } else {
            parent[u] = find(parent[u], parent);

        }

        return parent[u];

    }


    public static void union(int u, int v, int[] parent, int[] rank) {

        u = find(u, parent);
        v = find(v, parent);

        if (rank[u] < rank[v]) {

            parent[u] = v;
        } else if (rank[v] < rank[u]) {
            parent[v] = u;
        } else {
            parent[u] = v;
            rank[u]++;
        }


    }
}
