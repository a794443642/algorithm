package algorithm.JavaCode.base;

import java.lang.reflect.Method;

public class Code03_InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 0-0 有序
        // 0-1 有序
        for(int i = 1; i < arr.length ; i++){
            for(int j = i -1 ; j>=0 && arr[j]>arr[j+1]; j--){
                swap(arr,j,j+1);
            }
        }

    }

    private static void swap(int[] arr, int j, int i) {
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[j] ^ arr[i];
        arr[j] = arr[j] ^ arr[i];
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        Object obj =new Code03_InsertionSort();
        try {
            Method method = obj.getClass().getDeclaredMethod("insertionSort",int[].class);
            SortCommonUtil.test(testTime, maxSize, maxValue, method, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
