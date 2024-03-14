package org.example;

/**
 * 细胞分裂算法
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2024/3/13 9:50
 */
public class CellDivision {
    public static void main(String[] args) {

        System.out.println(exponential(10));
        System.out.println(exponential2(10));
    }

    /**
     * 指数阶（循环实现）
     *
     * @author dingpeihua
     * @date 2024/3/13 9:54
     * @version 1.0
     */
    static long exponential(int n) {
        long count = 0, base = 1;
        // 细胞每轮一分为二，形成数列 1, 2, 4, 8, ..., 2^(n-1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < base; j++) {
                count++;
            }
            base *= 2;
        }
        // count = 1 + 2 + 4 + 8 + .. + 2^(n-1) = 2^n - 1
        return count;
    }

    /**
     * 动态规划方案求细胞分裂数
     *
     * @param n
     * @author dingpeihua
     * @date 2024/3/13 9:48
     * @version 1.0
     */
    static long exponential2(int n) {
        long count = 1;
        long base = 1;
        System.out.println("base:" + base + ",count:" + count);
        // 细胞每轮一分为二，形成数列 1, 2, 4, 8, ..., 2^(n-1)
        for (int i = 1; i < n; i++) {
            base *= 2;
            count += base;
            System.out.println("base:" + base + ",count:" + count);
        }
        // count = 1 + 2 + 4 + 8 + .. + 2^(n-1) = 2^n - 1
        return count;
    }
}
