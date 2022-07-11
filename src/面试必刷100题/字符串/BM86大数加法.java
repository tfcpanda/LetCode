package 面试必刷100题.字符串;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Author: tfc
 * @Date: 2022/6/24
 * @Description:
 */
public class BM86大数加法 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public static String solve(String s, String t) {
        // write code here

        String a = " ";

        //判断字符串是否为空
        if (a.equals(s)) {
            return t;
        }
        if (a.equals(t)) {
            return s;
        }
        //加上位数
        for (int i = s.length(); i > 0; i--) {
            char c = s.charAt(i);


        }

        HashMap<Character,Integer> mp = new HashMap<>(16);





        return "a";
    }

    public static void main(String[] args) {

    }
}

