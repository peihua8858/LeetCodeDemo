package org.example;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2024/3/12 17:59
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 8, 4, 2, 90, 6, 30};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序，时间复杂度O(n^2)
     *
     * @param nums
     * @author dingpeihua
     * @date 2024/3/12 17:59
     * @version 1.0
     */
    static int bubbleSort(int[] nums) {
        int count = 0; // 计数器
        // 外循环：未排序区间为 [0, i]
        for (int i = nums.length - 1; i > 0; i--) {
            // 内循环：将未排序区间 [0, i] 中的最大元素交换至该区间的最右端
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换 nums[j] 与 nums[j + 1]
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    count += 3; // 元素交换包含 3 个单元操作
                }
            }
        }
        return count;
    }
}
