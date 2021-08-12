package org.example.jianzhi.stack;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174
 *
 * @author lifei
 */
public class Jz21 {
    /**
     * 模拟
     * <p>
     * 遍历 popA 中的每个元素时：
     * 如果栈非空、且栈顶元素是 popA 对应元素，栈顶元素出栈，popIndex++；
     * 其他情况，则 pushA 元素入栈，pushIndex++ 但是 popIndex 不加。
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        for (int popIndex = 0, pushIndex = 0; popIndex < popA.length; ) {
            if (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            } else {
                // 已知栈顶元素不是 popA 对应元素，
                // 且 pushA 已经没有元素可以进栈
                if (pushIndex == pushA.length) {
                    break;
                }
                stack.push(pushA[pushIndex++]);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz21().IsPopOrder(
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{4, 3, 5, 1, 2}
                )
        );
    }
}
