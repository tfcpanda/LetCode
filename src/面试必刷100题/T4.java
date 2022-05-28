package 面试必刷100题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tfc
 * @Date: 2022/5/8
 * @Description:
 */
public class T4 {

    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            mp.put(str.charAt(i), mp.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (mp.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        int aadsfasdfsa = FirstNotRepeatingChar("aadsfasdfsa");
        System.out.println(aadsfasdfsa);
    }

    /**
     * @Author: tfc
     * @Date: 2022/5/20
     * @Description:
     */
    public static class t3 {
        public static void main(String[] args) {
            for (int i = 0; i < 133 ;i ++){
                System.out.println((char) i);
            }
        }
    }

    /**
     * @Author: tfc
     * @Date: 2022/5/20
     * @Description:
     */
    public static class t2 {


        public static void main(String[] args) {
            String s = trans("This is a sample", 16);
            System.out.println(s);
        }


        public static String trans(String s, int n) {
            //如果字符为0，则返回0
            if (n == 0) {
                return s;
            }
            //如果不为0
            //1 大小写装换
            StringBuffer a = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                //大写字母
                if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
                    char b = (char) (s.charAt(i) - 'A' + 'a');
                    a.append(b);
                    //小写转大写
                } else if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                    char c = (char) (s.charAt(i) - 'a' + 'A');
                    a.append(c);
                } else {
                    a.append(s.charAt(i));
                }
            }

            a = a.reverse();


            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == ' '){

                }
            }

            //2 整个翻转
            //3 单个翻转


            return s;
        }
    }

    /**
     * @author 田付成
     * @date 2021/5/21 10:39
     */

    public static class T1 {
        public static void main(String[] args) {
            int[] a = {3, 2, 4};
            int[] ints = twoSum1(a, 6);
            for (int i = 0; i < ints.length; i++) {
                System.out.println(ints[i]);
            }


        }


        static int[] twoSum(int[] nums, int target) {
            int num = nums.length;
            for (int i = 0; i < num; i++) {
                for (int j = i + 1; j < num; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return nums;
        }

        public static int[] twoSum1(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>(10);
            map.put(nums[0], 0);
            for (int i = 1; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return nums;
        }

    }
}
