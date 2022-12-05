package algorithm.JavaCode.base;

public class Code05_BSNearLeafOrRight {

    // 在arr上，找满足>=value的位置
    public static int nearLeafIndex(int[] arr, int value){
        int L = 0;
        int R = arr.length-1;
        int index = -1; //记录位置
        while(L<=R){
            int mid = L + ((R-L)>>1);
            if(arr[mid]>=value){
                index = mid;
                R = mid -1;
            }else{
                L = mid+1;
            }
        }
        return index;
    }

    // 在arr上，找满足<=value的位置
    public static int nearRightIndex(int[] arr, int value){
        int L = 0;
        int R = arr.length-1;
        int index = -1; //记录位置
        while(L<=R){
            int mid = L + ((R-L)>>1);
            if(arr[mid]<=value){
                index = mid;
                L = mid + 1;
            }else{
                R = mid-1;
            }
        }
        return index;
    }
    
}
