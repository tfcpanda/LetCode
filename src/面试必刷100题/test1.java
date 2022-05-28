package 面试必刷100题;

/**
 * @Author: tfc
 * @Date: 2022/5/28
 * @Description:
 */
public class test1 {

    public static void main(String[] args) {
        String[] strs = {"abca", "abc", "abca", "abc", "abcc"};
        merge(new int[]{4,1,6}, 3, new int[]{1,5,3}, 3);
    }


    public static void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n -1 ;
        int[] arr = new int[m + n];
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                arr[k--] = A[i--];
            } else {
                arr[k--] = B[j--];
            }
        }

        if (i < 0) {
            while (j >= 0) {
                arr[k--] = B[j--];
            }
        }


    }


}
