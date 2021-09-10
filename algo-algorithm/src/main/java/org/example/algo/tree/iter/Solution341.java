package org.example.algo.tree.iter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution341 {
    public class NestedIterator implements Iterator<Integer> {
        private LinkedList<NestedInteger> list;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.list = new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {
            return this.list.removeFirst().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!this.list.isEmpty() && !this.list.get(0).isInteger()) {
                List<NestedInteger> first = this.list.removeFirst().getList();
                for (int i = first.size() - 1; i >= 0; i--) {
                    this.list.addFirst(first.get(i));
                }
            }
            return !this.list.isEmpty();
        }
    }

    public static void main(String[] args) {
    }
}
