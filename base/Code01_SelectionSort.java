package algorithm.JavaCode.base;

import java.util.Arrays;

public class Code01_SelectionSort {
    /**
     * 选择排序
     * 
     * @param arr
     */
    public static void selectSort(int[] arr) {
        // 数组为空或者长度小于2 无需排序
        if (arr == null || arr.length < 2) {
            return;
        }
        /**
         * 0 ~ N-1
         * 1 ~ N-1
         */
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }
    /*
     * 交换数组位置
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    /*
     * 生成随机数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() - (int) (maxValue * Math.random()));
        }
        return arr;
    }
    
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    /**
     * 复制数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int res[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (!isEqual(arr1, arr2)) {
                succed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succed?"nice":"FUcking fucked!");
        int[] arr =generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectSort(arr);
        printArray(arr);
    }
    public static void printArray(int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
    }
    /**
     * 两数组是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}