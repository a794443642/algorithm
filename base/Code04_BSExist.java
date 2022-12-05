package algorithm.JavaCode.base;

public class Code04_BSExist {
    /*
     * 二分查找数组是否存
     */
    public static boolean exist(int[] sortedArr,int num){
        if(sortedArr == null || sortedArr.length == 0){
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        // L...R
        while(L<R){
            int mid = L + ((R-L)>>1);
            if(sortedArr[mid] == num){
                return true;
            }else if(sortedArr[mid] > num){
                R = mid - 1;
            }else if(sortedArr[mid] < num){
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }
    
}
