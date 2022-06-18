package 面试必刷100题.链表;

/**
 * @Author: tfc
 * @Date: 2022/6/9
 * @Description:
 */
public class 创建链表2 {

    //创建一个链表的类
    static class ListNode {
        int val;    //数值 data
        ListNode next;    // 结点 node

        ListNode(int x) {    //可以定义一个有参构造方法，也可以定义一个无参构造方法
            val = x;
        }

        // 添加新的结点
        public void add(int newval) {
            ListNode newNode = new ListNode(newval);
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.add(newval);
            }
        }

        // 打印链表
        public void print() {
            System.out.print(this.val);
            if (this.next != null) {
                System.out.print("-->");
                this.next.print();
            }
        }
    }


    public static void main(String[] args) {
        //创建链表对象 l1 （对应有参 和 无参 构造方法）
        ListNode l1 = new ListNode(1);
        l1.add(2);                //插入结点，打印
        l1.add(3);
        l1.print();


    }
}
