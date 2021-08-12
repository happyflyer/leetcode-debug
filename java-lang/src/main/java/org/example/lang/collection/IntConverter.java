package org.example.lang.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://blog.csdn.net/weixin_44367006/article/details/96732411
 *
 * @author lifei
 */
public class IntConverter {
    /**
     * int[] => IntStream => Stream<Integer> => List<Integer>
     */
    public List<Integer> intArray2IntegerList(int[] ints) {
        return Arrays.stream(ints).boxed().collect(Collectors.toList());
    }

    /**
     * int[] => IntStream => Stream<Integer> => Integer[]
     */
    public Integer[] intArray2IntegerArray(int[] ints) {
        return Arrays.stream(ints).boxed().toArray(Integer[]::new);
    }

    /**
     * asList 返回的是 Arrays 里的静态私有类 ArrayList，
     * 而不是 java.util 里的 ArrayList，它无法自动扩容。
     */
    public List<Integer> integerArray2IntegerList(Integer[] integers) {
        return new ArrayList<>(Arrays.asList(integers));
    }

    /**
     * Integer[] => Stream<Integer> => IntStream => int[]
     */
    public int[] integerArray2IntArray(Integer[] integers) {
        return Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
    }

    /**
     * List<Integer> => IntStream => int[]
     */
    public int[] integerList2IntArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 方法里的参数是一个数组，所以要规定长度，
     * 也有无参的方法，但是要进行转型，不推荐。
     */
    public Integer[] integerList2IntegerArray(List<Integer> list) {
        return list.toArray(new Integer[0]);
    }

    int[] ints;
    Integer[] integers;
    List<Integer> list;

    public IntConverter() {
        ints = new int[]{1, 2, 3};
        integers = new Integer[]{1, 2, 3};
        list = new ArrayList<>(Arrays.asList(1, 2, 3));
    }

    public static void main(String[] args) {
        IntConverter converter = new IntConverter();
        System.out.println(
                converter.intArray2IntegerList(converter.ints)
        );
        System.out.println(
                Arrays.toString(
                        converter.intArray2IntegerArray(converter.ints)
                )
        );
        System.out.println(
                Arrays.toString(
                        converter.integerArray2IntArray(converter.integers)
                )
        );
        System.out.println(
                converter.integerArray2IntegerList(converter.integers)
        );
        System.out.println(
                Arrays.toString(
                        converter.integerList2IntArray(converter.list)
                )
        );
        System.out.println(
                Arrays.toString(
                        converter.integerList2IntegerArray(converter.list)
                )
        );
    }
}
