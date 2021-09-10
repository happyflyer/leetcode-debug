package org.example.algo.cache.lru;

/**
 * @author lifei
 */
public class Node {
    public final int key;
    public final int val;
    public Node prev;
    public Node next;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
