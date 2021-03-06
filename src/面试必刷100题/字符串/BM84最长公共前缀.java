package 面试必刷100题.字符串;

/**
 * @Author: tfc
 * @Date: 2022/5/20
 * @Description:
 */
public class BM84最长公共前缀 {


//    　　1.数组类型[] 数组名 = new 数组类型[数组长度];
//　     　int[] ids = new int[100];
//　　    2.数组类型[] 数组名 = new 数组类型[]{数组元素0,数组元素1,...};
//　　      String[] names = new String[]{"张三","tom",...};
//        3.数组类型[] 数组名 = {数组元素0,数组元素1,...};
//        　Object[] object = {"张三","tom",...};

    public static void main(String[] args) {
        String[] strs = {"a"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }


    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        //空字符串数组
        if (n == 0) {
            return "";
        }


        //遍历第一个字符串的长度
        for (int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);

            //遍历后续的字符串
            for (int j = 1; j < n; j++) {
//                char c = strs[j].charAt(i);
                //如果第一个字符串位数大于别的字符串就结束
                //如果字符串不同也就结束
                if (i == strs[j].length() || strs[j].charAt(i) != temp) {
                    //不相同则结束
                    return strs[0].substring(0, i);
                }
            }
        }
        //后续字符串有整个字一个字符串的前缀
        return strs[0];
    }


}
