package org.example.algo.unionfind;

/**
 * @author lifei
 */
public interface UnionFind {
    /**
     * 将p和q连接
     */
    void union(int p, int q);

    /**
     * 判断p和q是否连通
     */
    boolean connected(int p, int q);

    /**
     * 返回图中有多少个连通分量
     */
    int count();
}
