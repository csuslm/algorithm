package scn1.algh.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 数组例题
 */
public class arrays_algh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int[] p = new int[n];//记录前缀和，需要一步提前处理，求区间和的题目非常适用
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            preSum += nums[i];
            p[i] = preSum;
        }
        while(scanner.hasNextInt()){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if(l==0){
                System.out.println(p[r]);
            }else{
                System.out.println(p[r] - p[l-1]);
            }
        }
        scanner.close();
        /**
         * a-b b = sum - a  -> Math.abs(2a - sum)
         */
    }

    /**
     * 二分查找target index
     * 区间左闭右闭版本
     *
     * @param nums
     * @return
     */
    private int binary_search_m1(int[] nums, int target) {
        int lef = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (lef <= right) {
            mid = lef + (right - lef) / 2;//防止同类型int相加超过int的最大范围
            if (target > nums[mid]) {
                lef = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找target index
     * 区间左闭右开
     *
     * @param nums
     * @return
     */
    private int binary_search_m2(int[] nums, int target) {
        int lef = 0;
        int right = nums.length;
        int mid = 0;
        while (lef < right) {
            mid = lef + (right - lef) / 2;//防止同类型int相加超过int的最大范围
            if (target > nums[mid]) {
                lef = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 原地移除数组中的元素，删除掉目标值元素，使得nums的前k个元素是剩余的元素
     * @Tips 使用快慢指针
     * @param nums
     * @param target
     * @return
     */
    private int remove_element_in_array(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                length--;
            }
        }
        return length;
    }

    /**
     * 双指针 一个指针寻找新数组元素 一个寻找新数组元素所在的index
     *
     * @param nums
     * @param target
     * @return
     */
    private int remove_element_in_array_double_pointer(int[] nums, int target) {
        int low_pointer = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != target) {
                nums[low_pointer] = nums[i];
                low_pointer++;
            }
        }
        return low_pointer;
    }


    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * 流解法
     *
     * @param nums
     * @return
     */
    private int[] array_ch_03(int[] nums) {
        int[] array = Arrays.stream(nums).map(n -> n * n)
                .sorted()
                .toArray();
        return array;
    }

    private int[] array_ch_03_2(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int index = nums.length - 1;
        while (i <= j) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[index] = nums[i] * nums[i];
                index--;
                i++;
            } else {
                result[index] = nums[j] * nums[j];
                index--;
                j--;
            }
        }
        return result;
    }

    public int array_ch01_eg1(int[] nums, int target) {
        return 1;
    }

    /**
     * 计算和符合要求的子数组长度，和大于等于s，的长度最小数组
     * 滑动窗口
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length;
        int length = nums.length;
        int lowPtr = 0;
        int fastPtr = 0;
        int temp = 0;
        while (lowPtr <= nums.length - 1 && fastPtr <= nums.length - 1) {
            temp += nums[fastPtr];
            if (temp >= target) {
                min = Math.min(min, fastPtr - lowPtr + 1);
                temp -= nums[lowPtr];
                lowPtr++;
            } else {
                fastPtr++;
            }
        }
        return min;
    }

    /**
     * 顺时针填充矩阵
     * 关键在于定义的规定不要变，定义左闭右开则一直就是左闭右开
     * 矩阵类型的的题：
     *
     * @param n
     * @Tips 做法就在于设定好四个边界，注意这四个边界的对应性，我认为1->n 0->n-1,同时设置好闭合条件
     * 这样才能保证运行到哪一步都是这个条件无特殊技巧
     */
    public int[][] generateMatrix(int n) {
        int[][] resultMatrix = new int[n][n];
        int startX = 0;
        int startY = 0;
        int i, j;
        int offset = 1;
        int count = 1;
        int loop = 1;//记录圈数
        while (loop <= n / 2) {
            for (j = startY; j < n - offset; j++) {
                resultMatrix[startX][j] = count++;
            }
            for (i = startX; i < n - offset; i++) {
                resultMatrix[i][j] = count++;
            }
            for (; j > startY; j--) {
                resultMatrix[i][j] = count++;
            }
            for (; i > startX; i--) {
                resultMatrix[i][j] = count++;
            }
            loop++;
            startY++;
            startX++;
            offset++;
        }
        if (n % 2 == 1) {
            resultMatrix[startX][startY] = count;
        }
        return resultMatrix;
    }

    /**
     * 循环打印矩阵中的值
     *
     * @param array
     * @return
     */
    public int[] spiralArray(int[][] array) {
        int[] res = new int[array.length * array[0].length];
        int t = 0;
        int r = array[0].length - 1;
        int l = 0;
        int b = array.length - 1;
        int index = 0;
        while (true) {
            for (int i = l; i <= r; i++) {
                res[index++] = array[t][i];
            }
            if (++t > b) break;
            for (int i = t; t <= b; t++) {
                res[index++] = array[i][r];
            }
            if (l > --r) break;
            for (int i = r; i >= l; i--) {
                res[index++] = array[b][i];
            }
            if (--b < t) break;
            for (int i = b; i >= t; i--) {
                res[index++] = array[i][l];
            }
            if (++l > r) break;
        }
        return res;
    }

    /**
     * 螺旋返回矩阵中的元素，顺时针顺序返回
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;
        int t = 0;
        int b = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            if (++t > b) break;
            for (int i = t; t <= b; t++) {
                res.add(matrix[i][r]);
            }
            if (l > --r) break;
            for (int i = r; i >= l; i--) {
                res.add(matrix[b][i]);
            }
            if (--b < t) break;
            for (int i = b; i >= t; i--) {
                res.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return res;
    }


}
