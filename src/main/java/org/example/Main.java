package org.example;

import org.apache.commons.math3.special.Erf;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
//    public static void main(String[] args) {
////        long n = 1000000000000000000L; // 抛掷次数
////        double mu = n * 9.0 / 2.0; // 抛掷和的期望值
////        double sigma = Math.sqrt(n * 36.0); // 抛掷和的标准差
////        double x = 2024.0; // 抛掷和的目标值
////        double p = 0.5 * (1 + Erf.erf((x - mu) / (sigma * Math.sqrt(2)))); // 抛掷和为2024的概率
////        System.out.println("The probability of rolling a sum of 2024 is " + p);
//        double p = calculateP();
//        System.out.println("The probability of rolling a sum of 2024 is " + p);
//    }
//    public static double calculateP() {
//        double p = 0.0;
//        BigInteger c;
//        for (int k = 1; k <= 9; k++) {
//            c = C(2023, k-1);
//            System.out.println("C is " + c);
//            p += c.doubleValue() * Math.pow(1.0/9.0, k);
//            System.out.println("p is " + p);
//        }
//        return p;
//    }
//    public static BigInteger C(int n, int m) {
//        if (m == 0 || m == n) {
//            return BigInteger.ONE;
//        }
//        BigInteger[][] dp = new BigInteger[n+1][m+1];
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = BigInteger.ONE;
//        }
//        for (int i = 0; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                dp[i][j] = BigInteger.ZERO; // 初始化为0
//            }
//        }
////        for (int j = 0; j <= m; j++) {
////            dp[0][j] = BigInteger.ONE;
////        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
////                System.out.println("i is " + i+",j is "+j);
////                System.out.println("dp is " + Arrays.deepToString(dp));
//                dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
//            }
//        }
//        return dp[n][m];
//    }

    public static void main(String[] args) {
//        int n = 1000;  // 假设抛掷1000次
//        int targetSum = 2024;
//
//        int count = 0;
//        for (int[] c : combinations(n, 8)) {
//            int s = sum(c);
//            if (s == targetSum) {
//                count++;
//            }
//        }
//
//        double p = count * Math.pow(1.0 / 9, n);
//        System.out.println(p);
//        // 计算和为2024的抛掷结果的数量
//        BigInteger count = BigInteger.ZERO;
//        for (int i = 1; i <= 8; i++) {
//            int target = 2024 - i;
//            if (target > 0 && target <= 9) {
//                count = count.add(comb(8, target - 1));
//            }
//        }
//
//        // 计算概率
//        BigInteger total_count = comb(2024, 9);
//        double probability = count.doubleValue() / total_count.doubleValue();
//        System.out.println(probability);

//        int n = 9;
//        int target = 2024;
//
//        long[][] dp = new long[n + 1][target + 1];
//        dp[0][0] = 1;
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= target; j++) {
//                for (int k = 1; k <= 9; k++) {
//                    if (j >= k) {
//                        dp[i][j] += dp[i - 1][j - k];
//                    }
//                }
//            }
//        }
//
//        long total = (long) Math.pow(9, n);
//        double prob = (double) dp[n][target] / total;
//        System.out.println(prob);


//        int faces = 9;
//        int targetSum = 2024;
//        double[][] prob = new double[targetSum+1][targetSum+1];
//        prob[0][0] = 1.0;
//
//        for (int tosses = 1; tosses <= targetSum; tosses++) {
//            for (int face = 1; face <= Math.min(faces, tosses); face++) {
//                for (int prevSum = 0; prevSum < tosses; prevSum++) {
//                    prob[tosses][tosses-face] += prob[tosses-1][prevSum] / faces;
//                }
//            }
//        }
//
//        double totalProb = 0.0;
//        for (double p : prob[targetSum]) {
//            totalProb += p;
//        }
//
//        System.out.println("抛掷的和为" + targetSum + "的概率是" + totalProb);
        int n = 10000;
        int count = 0;
        while (n > 0) {
            int sum = sum();
            if (sum == 2024) {
                System.out.println("sum>>>"+sum);
                count++;
            }
            n--;
        }
        System.out.println(count);
    }

    static int sum() {
        int sum = 0;
        int targetSum = 2024;
        Random random = new Random();
        while (sum <= targetSum) {
            sum += (random.nextInt(9) + 1);
        }
        System.out.println(sum);
        return sum;
    }

    private static List<List<Integer>> findCombinations(int targetSum, int... nums) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(targetSum, nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void findCombinations(int targetSum, int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        if (targetSum == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (targetSum >= nums[i]) {
                current.add(nums[i]);
                findCombinations(targetSum - nums[i], nums, i, current, result);
                current.remove(current.size() - 1);
            }
        }
    }


    // 计算组合数
    public static BigInteger comb(int n, int k) {
        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(n - i + 1));
            System.out.println(numerator);
            denominator = denominator.multiply(BigInteger.valueOf(i));
            System.out.println(denominator);
        }
        return numerator.divide(denominator);
    }

    private static List<int[]> combinations(int n, int k) {
        List<int[]> res = new ArrayList<>();
        int[] c = new int[k];
        for (int i = 0; i < k; i++) {
            c[i] = i;
        }
        while (c[0] < n - k + 1) {
            res.add(Arrays.copyOf(c, k));
            int t = k - 1;
            while (t != 0 && c[t] == n - k + t) {
                t--;
            }
            c[t]++;
            for (int i = t + 1; i < k; i++) {
                c[i] = c[i - 1] + 1;
            }
        }
        return res;
    }

    // 计算数组元素之和
    private static int sum(int[] arr) {
        int res = 0;
        for (int x : arr) {
            res += x;
        }
        return res;
    }
}