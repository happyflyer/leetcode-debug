package org.example.leetcode.lang.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://mp.weixin.qq.com/s/zQBN3UvJDhRTKP6SzcZFKw
 * <p>
 * HashMap 遍历从大的方向来说，可分为以下 4 类：
 * 迭代器（Iterator）方式遍历；
 * For Each 方式遍历；
 * Lambda 表达式遍历（JDK 1.8+）;
 * Streams API 遍历（JDK 1.8+）。
 * <p>
 * 但每种类型下又有不同的实现方式，因此具体的遍历方式又可以分为以下 7 种：
 * 使用迭代器（Iterator）EntrySet 的方式进行遍历；
 * 使用迭代器（Iterator）KeySet 的方式进行遍历；
 * 使用 For Each EntrySet 的方式进行遍历；
 * 使用 For Each KeySet 的方式进行遍历；
 * 使用 Lambda 表达式的方式进行遍历；
 * 使用 Streams API 单线程的方式进行遍历；
 * 使用 Streams API 多线程的方式进行遍历。
 * <p>
 * 在使用迭代器或者 for 循环时，其实已经遍历了一遍 Map 集合了，
 * 因此再使用 map.get(key) 查询时，相当于遍历了两遍。
 * 所以，EntrySet 的性能比 KeySet 的性能高出了一倍，
 * 因为 KeySet 相当于循环了两遍 Map 集合，而 EntrySet 只循环了一遍。
 * <p>
 * 能在遍历中使用集合 map.remove() 来删除数据，这是非安全的操作方式；
 * 可以使用迭代器的 iterator.remove() 的方法来删除数据，这是安全的删除集合的方式。
 * 可以使用 Lambda 中的 removeIf 来提前删除数据；
 * 可以使用 Stream 中的 filter 过滤掉要删除的数据进行循环，
 * 可以在 for 循环前删除数据在遍历也是线程安全的。
 *
 * @author lifei
 */
public class MapIteration {
    Map<Integer, String> map = new HashMap<>();

    public MapIteration() {
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
    }

    public void testIteratorEntrySet() {
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void testIteratorKeySet() {
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key + ": " + map.get(key));
        }
    }

    public void testForEachEntrySet() {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void testForEachKeySet() {
        for (Integer key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    public void testLambda() {
        map.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }

    public void testStreamApi() {
        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
    }

    public void testParallelStreamApi() {
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
    }

    public static void main(String[] args) {
        MapIteration iteration = new MapIteration();
        iteration.testIteratorEntrySet();
        iteration.testIteratorKeySet();
        iteration.testForEachEntrySet();
        iteration.testForEachKeySet();
        iteration.testLambda();
        iteration.testStreamApi();
        iteration.testParallelStreamApi();
    }
}
