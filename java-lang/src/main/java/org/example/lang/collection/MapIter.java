package org.example.lang.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://mp.weixin.qq.com/s/zQBN3UvJDhRTKP6SzcZFKw
 *
 * @author lifei
 */
public class MapIter {
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

    Map<Integer, String> map = new HashMap<>();

    public MapIter() {
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
    }

    public static void main(String[] args) {
        MapIter iteration = new MapIter();
        iteration.testIteratorEntrySet();
        iteration.testIteratorKeySet();
        iteration.testForEachEntrySet();
        iteration.testForEachKeySet();
        iteration.testLambda();
        iteration.testStreamApi();
        iteration.testParallelStreamApi();
    }
}
