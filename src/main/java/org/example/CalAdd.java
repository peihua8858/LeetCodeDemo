package org.example;

/**
 * 计算1+2+3+4+...+n的和
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2024/3/13 10:57
 */
public class CalAdd {
    public static void main(String[] args) {
        int n = 1000000000;
        TimeTool.check("sum1", () -> System.out.println(sum1(n)));
        TimeTool.check("sum2", () -> System.out.println(sum2(n)));
    }

    public static long sum1(int n) {
        long result = 0;
        for (int i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long sum2(int n) {
        return (1L + n) * n / 2L;
    }
}
