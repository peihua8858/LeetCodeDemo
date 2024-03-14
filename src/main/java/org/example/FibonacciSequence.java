package org.example;

/**
 * 斐波那契数列
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2024/3/12 14:35
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        int n = 10;
//        TimeTool.check("fib", () -> System.out.println(fib(n)));
        TimeTool.check("fib1", () -> System.out.println(fib1(n)));
        TimeTool.check("fib1", () -> System.out.println(fib2(n)));
        TimeTool.check("fib1", () -> System.out.println(fib3(n)));
    }

    static long fib1(int n) {
        if (n <= 1) {
            return n;
        }
        long first = 0;
        long second = 1;
        for (int i = 0; i < n - 1; i++) {
            long sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    static long fib2(int n) {
        if (n <= 1) {
            return n;
        }
        long first = 0;
        long second = 1;
        while (n-- > 1) {
            second += first;
            first = second - first;
        }
        return second;
    }

    /**
     * 斐波那契的线性代数解法-特征方程
     * F(n)=1/√5[(1+√5/2)^n-(1-√5/2)^n]
     * 时间复杂度是O(1)
     * @param n
     * @author dingpeihua
     * @date 2024/3/13 14:11
     * @version 1.0
     */
    static long fib3(int n) {
        double c = Math.sqrt(5);
        return (long) ((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
    }

    /**
     * 斐波那契数列：递归
     *
     * @param n
     * @author dingpeihua
     * @date 2024/3/12 14:35
     * @version 1.0
     */
    static int fib(int n) {
        // 终止条件 f(1) = 0, f(2) = 1
        if (n == 1 || n == 2)
            return n - 1;
        // 递归调用 f(n) = f(n-1) + f(n-2)
        int res = fib(n - 1) + fib(n - 2);
        // 返回结果 f(n)
        return res;
    }
}
