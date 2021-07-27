package org.example.leetcode;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    static Solution solution;

    @BeforeClass
    public static void beforeAll() {
        solution = new Solution();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {}
        });
    }

    // input
    // expected;

    // 有参构造方法

    @Test
    public void test() {
        assertEquals(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertNotEquals(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertArrayEquals(new int[]{}, new int[]{});
        assertTrue(true);
        assertFalse(false);
    }
}
