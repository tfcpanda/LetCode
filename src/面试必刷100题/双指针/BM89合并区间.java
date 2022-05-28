package 面试必刷100题.双指针;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: tfc
 * @Date: 2022/5/28
 * @Description:
 */
public class BM89合并区间 {


    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        Interval a = new Interval(10, 30);
        Interval b = new Interval(20, 60);
        Interval c = new Interval(80, 100);
        Interval d = new Interval(150, 180);

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        ArrayList<Interval> merge = merge(list);

        for (int i = 0; i < merge.size(); i++) {
            System.out.println(merge.get(i));
        }


    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        //去除特殊情况
        if (intervals.size() == 0) {
            return res;
        }
        //重载比较，按照区间首排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });
        //放入第一个区间
        res.add(intervals.get(0));
        int count = 0;
        //遍历后续区间，查看是否与末尾有重叠
        for (int i = 1; i < intervals.size(); i++) {
            Interval o1 = intervals.get(i);
            Interval origin = res.get(count);
            if (o1.start > origin.end) {
                res.add(o1);
                count++;
                //区间有重叠，更新结尾
            } else {
                res.remove(count);
                Interval s = new Interval(origin.start, o1.end);
                if (o1.end < origin.end) {
                    s.end = origin.end;
                }
                res.add(s);
            }
        }
        return res;
    }
}
