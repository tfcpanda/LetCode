package 面试必刷100题.链表;

/**
 * @Author: tfc
 * @Date: 2022/6/9
 * @Description:
 */
public class BM4合并两个排序的链表 {


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode Merge(ListNode list1, ListNode list2) {
        //如果一个为空，直接返回另一个
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;

        //如果两个都不为空
        while (list1 != null && list2 != null) {
            //取最小值的节点
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        //哪个链表还有剩，直接连在后面
        if (list1 != null) {
            cur.next = list1;
        } else {
            cur.next = list2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode newNode2 = new ListNode(3);
        list1.next = newNode2;
        ListNode newNode3 = new ListNode(5);
        newNode2.next = newNode3;


        ListNode list2 = new ListNode(2);
        ListNode ewNode2 = new ListNode(4);
        list2.next = ewNode2;
        ListNode ewNode3 = new ListNode(6);
        ewNode2.next = ewNode3;


        ListNode merge = Merge(list1, list2);
        System.out.println(merge.val);


    }

}
