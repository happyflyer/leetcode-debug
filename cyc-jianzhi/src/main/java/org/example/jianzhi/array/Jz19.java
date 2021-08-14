package org.example.jianzhi.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172
 *
 * @author lifei
 */
public class Jz19 {
    /**
     * 模拟
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int[] ans = new int[matrix.length * matrix[0].length];
        int k = 0;
        int minRow = 0;
        int maxRow = matrix.length - 1;
        int minCol = 0;
        int maxCol = matrix[0].length - 1;
        while (minRow <= maxRow && minCol <= maxCol) {
            // 上
            for (int i = minCol; i <= maxCol; i++) {
                ans[k++] = matrix[minRow][i];
            }
            // 右
            for (int i = minRow + 1; i <= maxRow; i++) {
                ans[k++] = matrix[i][maxCol];
            }
            // 下
            if (minRow != maxRow) {
                for (int i = maxCol - 1; i >= minCol; i--) {
                    ans[k++] = matrix[maxRow][i];
                }
            }
            // 左
            if (minCol != maxCol) {
                for (int i = maxRow - 1; i > minRow; i--) {
                    ans[k++] = matrix[i][minCol];
                }
            }
            minRow++;
            maxRow--;
            minCol++;
            maxCol--;
        }
        return intArray2IntegerArrayList(ans);
    }

    static ArrayList<Integer> intArray2IntegerArrayList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz19().printMatrix(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16}
                        }
                )
        );
    }
}
