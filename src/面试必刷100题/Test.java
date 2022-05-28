package 面试必刷100题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tfc
 * @Date: 2022/5/6
 * @Description:
 */
public class Test {


    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Test test = new Test();
        int a = test.romanToInt("III");
        System.out.println(a);
    }

    //字符串转换

}
