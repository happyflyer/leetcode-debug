package org.example.algo.unionfind;

/**
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFindImpl2(26);
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if (uf.connected(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
