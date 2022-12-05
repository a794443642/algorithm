package algorithm.JavaCode.base;

import java.lang.reflect.Method;

public class Code15_MergeSort {
    // 递归方式实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // 将arr[i...j]排有序
    private static void process(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int mid = i + ((j - i) >> 1);
        process(arr, i, mid);
        process(arr, mid + 1, j);
        merge(arr, i, mid, j);
    }

    // 非递归方式实现
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1; // 每次合并的步长
        while (mergeSize < N) {
            int L = 0; // 合并左区间 第一个位置
            while (L < N) {
                if (mergeSize >= N - L) {
                    break;
                }
                int M = L + mergeSize - 1;
                int R = M + Math.min(mergeSize, N - M - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            // 防止溢出
            if (mergeSize > N / 2){
                break;
            }
                mergeSize <<= 1;
        }
    }

    // 合并有序数组
    private static void merge(int[] arr, int i, int mid, int j) {
        int[] help = new int[j - i + 1];
        int tempIndex = 0;
        int p1 = i;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= j)
            help[tempIndex++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        // 要么p1越界 要么p2越界
        while (p1 <= mid) {
            help[tempIndex++] = arr[p1++];
        }
        while (p2 <= j) {
            help[tempIndex++] = arr[p2++];
        }
        for (int k = 0; k < help.length; k++) {
            arr[i + k] = help[k];
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        Object obj = new Code15_MergeSort();
        Method meathod = obj.getClass().getDeclaredMethod("mergeSort2", int[].class);
        SortCommonUtil.test(testTime, maxSize, maxValue, meathod, obj);
    }
}
