package 面试必刷100题.哈希表;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: tfc
 * @Date: 2022/6/22
 * @Description:
 */
public class BM50两数之和 {


    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[0];
        //创建哈希表,两元组分别表示值、下标
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        //在哈希表中查找target-numbers[i]
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            //若是没找到，将此信息计入哈希表
            if (!hash.containsKey(temp)) {
                hash.put(numbers[i], i);
            } else {
                //否则返回两个下标+1
                return new int[]{hash.get(temp) + 1, i + 1};
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] strs = {3, 2, 4};
        int[] ints = twoSum(strs, 6);

        System.out.println(Arrays.toString(ints));
    }


}
