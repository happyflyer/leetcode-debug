package org.example.leetcode.exam.shopee;

/**
 * 机器人漫步
 * 详细描述
 * 一个机器人要从起始点A和终点B。机器人从起点开始，
 * 每次能从上，下，左，右移动一步通过一个房间。并且每个房间只能路过一次。
 * 设定机器人的健康数为H，如果经过的房间是正整数a，
 * 那么机器人经过这个房间就能获得对应的健康点数，健康数变成H+a，
 * 如果经过的房间为负数，那么机器人就会失去对应的健康点数a，机器人的健康数变成H-a，
 * 问如果要保证机器人生命数一直是正数，H初始值至少为多少？
 * 房间点数由一个二维数组M*N 表示，起点和终点由一个一维数组组成。
 * <p>
 * 房间点数由一个二维数组M*N 表示，起点和终点由一个一维数组组成。
 * 1 <= M,N <= 200
 * m == rooms.length
 * n == rooms[i].length
 * -1000 <= rooms[i][j] <= 1000
 * 0 <= i,j <= M,N
 * <p>
 * 输入：[[-2,-3,3],[-5,-10,1],[10,30,-5]],[0,0],[2,2]
 * 输出：7
 * <p>
 * 输入：[[100]],[0,0],[0,0]
 * 输出：1
 *
 * @author lifei
 */
public class Solution1 {
    public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {
        // write code here
        return 0;
    }

    public static void main(String[] args) {
    }
}
