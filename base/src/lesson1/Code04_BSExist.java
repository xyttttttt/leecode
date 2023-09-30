package lesson1;

public class Code04_BSExist {


    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length-1;
        int mid = 0;
        while (L< R){
            //mid = L + (R-L)/2;
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num){
                break;
            }
            if (sortedArr[mid]  < num){
                R = mid-1;
            }
            if (sortedArr[mid] > num){
                L = mid +1;
            }
        }
        return sortedArr[mid] == num;
    }

}
