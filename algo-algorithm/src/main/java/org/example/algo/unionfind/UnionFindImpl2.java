package org.example.algo.unionfind;

/**
 * @author lifei
 */
public class UnionFindImpl2 implements UnionFind {
    private int count;
    private int[] parent;
    private int[] size;

    public UnionFindImpl2(int n) {
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // 树平衡优化
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += rootQ;
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += rootP;
        }
        this.count--;
    }

    private int find(int x) {
        while (parent[x] != x) {
            // 路径压缩
            parent[x] = parent[parent[x]];
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
