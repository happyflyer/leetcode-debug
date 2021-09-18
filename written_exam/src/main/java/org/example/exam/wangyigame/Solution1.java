package org.example.exam.wangyigame;

import java.util.*;

/**
 * 题目描述：
 * 输入：
 * 3 6
 * 10001 xianwang
 * 10002 xiaoli
 * 10003 xiaoming
 * 10003 a 22
 * 10001 a 6
 * 10002 b 24
 * 10001 a 10
 * 10003 b 99
 * 10002 b 15
 * 输出：
 * xiaoming 121
 * 说明：
 * 通过：10%
 *
 * @author lifei
 */
public class Solution1 {
    public static void getAns(int n, int m,
                              String[] aId, String[] aName,
                              String[] bId, String[] bActivityId, int[] bScore) {
        Map<String, Integer> userToScore = new HashMap<>();
        Map<String, Set<String>> userToActivity = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String userId = bId[i];
            Set<String> set = userToActivity.getOrDefault(userId, new HashSet<>());
            set.add(bActivityId[i]);
            userToActivity.put(userId, set);
            int s = userToScore.getOrDefault(userId, 0);
            userToScore.put(userId, s + bScore[i]);
        }
        for (Map.Entry<String, Set<String>> entry : userToActivity.entrySet()) {
            if (entry.getValue().size() < 2) {
                userToScore.remove(entry.getKey());
            }
        }
        // System.out.println(userToActivity);
        // System.out.println(userToScore);
        List<Record> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (userToScore.containsKey(aId[i])) {
                list.add(new Record(aName[i], userToScore.get(aId[i])));
            }
        }
        Collections.sort(list);
        for (Record r : list) {
            System.out.println(r.name + " " + r.total);
        }
    }

    public static class Record implements Comparable<Record> {
        String name;
        int total;

        public Record(String name, int total) {
            this.name = name;
            this.total = total;
        }

        @Override
        public int compareTo(Record other) {
            if (this.total > other.total) {
                return 1;
            } else if (this.total == other.total) {
                return this.name.compareTo(other.name);
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] aId = new String[n];
        String[] aName = new String[n];
        int i = 0;
        while (i < n) {
            aId[i] = sc.next();
            aName[i] = sc.next();
            i++;
        }
        String[] bUserId = new String[m];
        String[] bActivityId = new String[m];
        int[] bScore = new int[m];
        int j = 0;
        while (j < m) {
            bUserId[j] = sc.next();
            bActivityId[j] = sc.next();
            bScore[j] = sc.nextInt();
            j++;
        }
        getAns(n, m, aId, aName, bUserId, bActivityId, bScore);
    }
}
