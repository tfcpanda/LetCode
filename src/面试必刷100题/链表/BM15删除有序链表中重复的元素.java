package 面试必刷100题.链表;

/**
 * @Author: tfc
 * @Date: 2022/6/9
 * @Description:
 */
public class BM15删除有序链表中重复的元素 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode newNode2 = new ListNode(1);
        list1.next = newNode2;
        ListNode newNode3 = new ListNode(2);
        newNode2.next = newNode3;

//        ListNode listNode = deleteDuplicates(list1);

        ListNode cur = list1;

        ListNode temp = list1;


        cur.next = cur.next.next;

    }
}
