package 面试必刷100题.哈希表;

import java.util.HashMap;

/**
 * @Author: tfc
 * @Date: 2022/6/23
 * @Description:
 */
public class BM53缺失的第一个正整数 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public static int minNumberDisappeared(int[] nums) {
        // write code here

        HashMap<Integer, Integer> mp = new HashMap<>();

        //循环记录
        for (int i = 0; i < nums.length; i++) {
            //用key - value  ,  把num[i] 当作key, value 记作1
            mp.put(nums[i], 1);
            //然后用n自加，判断hash conkey里面有没有最小的正整数

        }

        int n = 1;
        while (mp.containsKey(n)) {
            n++;

        }
        return n;


    }

    public static void main(String[] args) {

        int a[] = {1, 0, 2};

        int i = minNumberDisappeared(a);

        System.out.println(i);
    }

}
