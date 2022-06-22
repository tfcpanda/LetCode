package 面试必刷100题.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: tfc
 * @Date: 2022/6/23
 * @Description:
 */
public class BM52数组中只出现一次的两个数字 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public static int[] FindNumsAppearOnce(int[] array) {
        // write code here
        HashMap<Integer, Integer> mp = new HashMap<>(10);
        ArrayList<Integer> list = new ArrayList<>();


        for (int i = 0; i < array.length; i++) {
            if (!mp.containsKey(array[i])) {
                mp.put(array[i], 1);
            } else {
                mp.put(array[i], mp.get(array[i]) + 1);
            }

        }

        for (int i = 0; i < array.length; i++) {
            if (mp.get(array[i]) == 1) {
                list.add(array[i]);
            }
        }

        if (list.get(0) > list.get(1)) {
            return new int[]{list.get(1), list.get(0)};
        } else {
            return new int[]{list.get(0), list.get(1)};

        }

    }

    public static void main(String[] args) {

        int a[] = {1, 4, 1, 6};

        int[] ints = FindNumsAppearOnce(a);

        System.out.println(Arrays.toString(ints));

    }


}
