package algorithm.JavaCode.base;

public class Code07_EvenTimesOddTimes {
    // arr中 只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    // arr中 有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        // eor = a^b
        // eor !=0
        // eor 必有一位是1
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (onlyOne ^ eor));
    }

    public static int bit1Counts(int num) {
        int count = 0;
        while (num != 0) {
            int rightOne = num & ((~num) + 1);
            count++;
            num ^= rightOne;
        }
        return count;
    }
    public static void main(String[] args) {
        int num =5465456;
        System.out.println(bit1Counts(num));
    }
}
