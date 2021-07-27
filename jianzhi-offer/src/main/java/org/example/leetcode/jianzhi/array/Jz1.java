package org.example.leetcode.jianzhi.array;

/**
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154
 *
 * @author lifei
 */
public class Jz1 {
    /**
     * 暴力法
     */
    public boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int cols = array[0].length;
        for (int[] ints : array) {
            for (int j = 0; j < cols; j++) {
                if (ints[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从右上角开始找
     * <p>
     * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
     * 因此，从右上角开始查找，
     * 就可以根据 target 和当前元素的大小关系来快速地缩小查找区间，
     * 每次减少一行或者一列的元素。
     * 当前元素的查找区间为左下角的所有元素。
     * <p>
     * | |0|1|2|3|4|5|
     * |0|<|<|<|<|<|v|
     * |1| | | | | |>|
     * |2| | | | | |>|
     * |3| | | | | |>|
     * |4| |t| | | |>|
     * |5| | | | | |>|
     */
    public boolean Find2(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int rows = array.length;
        int cols = array[0].length;
        int curRow = 0;
        int curCol = cols - 1;
        while (curRow <= rows - 1 && curCol >= 0) {
            if (target == array[curRow][curCol]) {
                return true;
            } else if (target > array[curRow][curCol]) {
                curRow++;
            } else {
                curCol--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz1().Find(
                        7,
                        new int[][]{
                                {1, 2, 8, 9},
                                {2, 4, 9, 12},
                                {4, 7, 10, 13},
                                {6, 8, 11, 15}}
                )
        );
    }
}
