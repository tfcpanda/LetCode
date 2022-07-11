package 面试必刷100题.字符串;

import java.util.HashMap;

/**
 * @Author: tfc
 * @Date: 2022/6/24
 * @Description:
 */
public class NC31第一个只出现一次的字符 {

    public static int FirstNotRepeatingChar(String str) {

        HashMap<Character, Integer> mp = new HashMap<>(16);

        for (int i = 0; i < str.length(); i++) {
            if (mp.containsKey(str.charAt(i))) {
                mp.put(str.charAt(i), mp.get(str.charAt(i)) + 1);
            } else {
                mp.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (mp.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int google = FirstNotRepeatingChar("aa");
        System.out.println(google);
    }
}
