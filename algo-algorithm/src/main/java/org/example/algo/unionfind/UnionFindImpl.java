package org.example.algo.unionfind;

/**
 * @author lifei
 */
public class UnionFindImpl implements UnionFind {
    private int count;
    private int[] parent;

    public UnionFindImpl(int n) {
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        this.count--;
    }

    private int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    @Override
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    @Override
    public int count() {
        return this.count;
    }
}
