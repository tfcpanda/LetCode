package 面试必刷100题.双指针;

/**
 * @Author: tfc
 * @Date: 2022/5/28
 * @Description:
 */
public class BM93盛水最多的容器 {

    public static void main(String[] args) {
        int i = maxArea(new int[]{1, 7, 3, 2, 4, 5, 8, 2, 7});
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        // write code here

        if (height.length < 2) {
            return 0;
        }

        int res = 0;
        //左边
        int left = 0;
        //右边
        int right = height.length - 1;

        while (left < right) {
            int cap = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, cap);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return res;
    }
}
