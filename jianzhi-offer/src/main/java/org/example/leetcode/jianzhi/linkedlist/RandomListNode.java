package org.example.leetcode.jianzhi.linkedlist;

/**
 * @author lifei
 */
public class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;

    RandomListNode(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "RandomListNode{" +
                "label=" + label +
                ", random=" + (random != null
                ? ("RandomListNode{label=" + random.label + "}@" + random.hashCode())
                : null) +
                "}@" + hashCode() +
                '\n' + (next != null ? (" -> " + next) : "");
    }
}
