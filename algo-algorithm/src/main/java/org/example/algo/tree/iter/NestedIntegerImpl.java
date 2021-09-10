package org.example.algo.tree.iter;

import java.util.List;

/**
 * @author lifei
 */
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
