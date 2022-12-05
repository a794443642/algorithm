package algorithm.JavaCode.base;

import java.util.Arrays;


public class Code02_BubbleSort {
    /*
     * 冒泡排序
     * 升序
     * 0 ~ N-1
     * 0 ~ N-2
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 1
        // 1 2
        // i-1 i
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // ^ 按位异或 同真或同假时，结果为假；两个变量一真一假时，结果为真。
    private static void swap(int[] arr, int j, int i) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int arr[] = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int)(Math.random() * (maxValue + 1)) -(int)(Math.random() * maxValue));
        }
        return arr;
    }

    public static int[] copyArray(int arr[]){
        if(arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public static void comparator(int arr[]){
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        boolean succed = true;
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if(!Code01_SelectionSort.isEqual(arr1,arr2)){
                succed = false;
                Code01_SelectionSort.printArray(arr1);
                Code01_SelectionSort.printArray(arr2);
                break;
            }
        }
        System.out.println(succed?"nice":"FUcking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        Code01_SelectionSort.printArray(arr);
        bubbleSort(arr);
        Code01_SelectionSort.printArray(arr);
    }
}
