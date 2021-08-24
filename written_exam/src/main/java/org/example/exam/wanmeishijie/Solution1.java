package org.example.exam.wanmeishijie;

import java.util.HashSet;

/**
 * 输入：3,[[1,2,1,0],[1,3,2,0],[2,3,4,0]]
 * 输出：3
 * ac:20%
 *
 * @author lifei
 */
public class Solution1 {
    public int minCost(int N, int[][] roads) {
        HashSet<Integer> set = new HashSet<>(N);
        int cost = 0;
        for (int[] road : roads) {
            if (road[3] == 1) {
                cost += road[2];
                set.add(road[0]);
                set.add(road[1]);
            }
        }
        while (set.size() < N) {
            int minPos = -1;
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (roads[i][3] == 0 && roads[i][2] < minCost) {
                    if (set.isEmpty()
                            || set.contains(roads[i][0])
                            || set.contains(roads[i][1])) {
                        minCost = Math.min(minCost, roads[i][2]);
                        minPos = i;
                    }
                }
            }
            set.add(roads[minPos][0]);
            set.add(roads[minPos][1]);
            cost += minCost;
            roads[minPos][3] = 1;
        }
        return cost;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution1().minCost(
                        3,
                        new int[][]{
                                {1, 2, 1, 0},
                                {1, 3, 2, 0},
                                {2, 3, 4, 0}
                        }
                )
        );
    }
}
