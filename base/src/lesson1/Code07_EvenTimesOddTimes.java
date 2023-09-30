package lesson1;

public class Code07_EvenTimesOddTimes {
    public static void printOddTimesNum1(int[] arr) {
        int eo = 0;
        for (int cur : arr){
            eo = eo^cur;
        }
        System.out.println(eo);
    }
    public static void printOddTimesNum2(int[] arr) {
        int eo =0;
        for (int cur : arr) {
            eo = eo ^ cur;
        }
        // 01001010          取反： 10110101        +1： 10110110
        //                                         eo： 01001010        00000010  = 2
        int rightOne = eo & (~eo + 1);
        int eOhasOne = 0;
        for (int cur: arr){
            if ((cur & rightOne )!=0){
                eOhasOne = eOhasOne ^ cur;
            }
        }
        System.out.println(eOhasOne);
        System.out.println(eo ^ eOhasOne);
    }

    public static void main(String[] args) {
/*        int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);*/

        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);

    }

}
