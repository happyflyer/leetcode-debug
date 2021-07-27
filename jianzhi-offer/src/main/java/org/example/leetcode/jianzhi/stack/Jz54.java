package org.example.leetcode.jianzhi.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207
 *
 * @author lifei
 */
public class Jz54 {
    Map<Character, Integer> map = new HashMap<>();
    Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        queue.offer(ch);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!queue.isEmpty() && map.get(queue.peek()) != 1) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            return '#';
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Jz54 jz54 = new Jz54();
        String input = "google";
        // String output = "ggg#ll";
        for (int i = 0; i < input.length(); i++) {
            jz54.Insert(input.charAt(i));
            System.out.println(jz54.FirstAppearingOnce());
        }
    }
}
