package 面试必刷100题.链表;

/**
 * @Author: tfc
 * @Date: 2022/5/30
 * @Description:
 */
public class BM1反转链表 {


    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        ListNode newNode2 = new ListNode(2);
        list1.next = newNode2;
        ListNode newNode3 = new ListNode(3);
        newNode2.next = newNode3;



        ListNode listNode = ReverseList(list1);
        System.out.println(listNode);

    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode temp = cur.next;

            cur.next = pre;

            pre = cur;

            cur = temp;
        }

        return pre;
    }
}
