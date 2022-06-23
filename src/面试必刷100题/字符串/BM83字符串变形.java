package 面试必刷100题.字符串;

/**
 * @Author: tfc
 * @Date: 2022/6/23
 * @Description:
 */
public class BM83字符串变形 {

    public static String trans(String s, int n) {
        // write code here

        StringBuffer stringBuilder = new StringBuffer();
        //1 全部大写变小写
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                stringBuilder.append(Character.toLowerCase(s.charAt(i)));
            } else if (Character.isLowerCase(s.charAt(i))) {
                stringBuilder.append(Character.toUpperCase(s.charAt(i)));
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }


        //2 整个逆转
        StringBuffer sb = stringBuilder.reverse();
        sb.append(' ');
        //里面单词逆转
        int start = 0;

        for (int i = 0; i < n+ 1; i++) {


            //遇到空格
            while (i < n +1  && sb.charAt(i) == ' ') {
                String temp = sb.substring(start, i);
                StringBuffer tempSting = new StringBuffer(temp);
                temp= tempSting.reverse().toString();
                StringBuffer replace = sb.replace(start, i, temp);
                start = i + 1;
                i++;
            }


        }

        sb.deleteCharAt(sb.length() -1);

        return sb.toString();

    }

    public static void main(String[] args) {
        String a = "This is a sample";
        String trans = trans(a, 16);
        System.out.println(trans);
    }
}
