package org.example.leetcode.tree;

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
    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    public class NestedIntegerImpl implements NestedInteger {
        private Integer val;
        private List<NestedInteger> list;

        public NestedIntegerImpl(Integer val) {
            this.val = val;
            this.list = null;
        }

        public NestedIntegerImpl(List<NestedInteger> list) {
            this.val = null;
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return this.val != null;
        }

        @Override
        public Integer getInteger() {
            return this.val;
        }

        @Override
        public List<NestedInteger> getList() {
            return this.list;
        }
    }

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
