package 面试必刷100题.链表;

import java.util.LinkedList;

/**
 * @Author: tfc
 * @Date: 2022/5/30
 * @Description:
 */
public class 创建链表 {

    public static class LinkListDemo {

        //节点类
        private class ListNode {
            private Object data;
            private ListNode next = null;

            ListNode() {
                data = null;
            }

            ListNode(Object data) {
                this.data = data;
            }
        }

        private static ListNode head;//头节点
        private ListNode temp;//临时节点


        //初始化链表，生成一个无数据的头节点
        LinkListDemo() {
            head = new ListNode();
        }

        /* ================以下方法是对链表的操作===================*/

        /**
         * 增加节点
         *
         * @param data
         */
        public void addNode(Object data) {
            ListNode node = new ListNode(data);
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }


        /**
         * 返回链表的长度
         *
         * @return
         */
        public int getLength() {
            temp = head;
            int length = 0;
            while (temp.next != null) {
                length++;
                temp = temp.next;
            }
            return length;
        }

        /**
         * 增加节点到指定的位置
         *
         * @param index
         * @param data
         */
        public void addNodeByIndex(int index, Object data) {
            if (index < 1 || index > getLength() + 1) {
                System.out.println("插入的位置不合法。");
                return;
            }
            int count = 1; //记录遍历的位置
            ListNode node = new ListNode(data);
            temp = head;
            while (temp.next != null) {
                if (index == count++) {
                    node.next = temp.next;
                    temp.next = node;
                    return;
                }
                temp = temp.next;
            }

        }

        /**
         * 删除指定位置的节点
         *
         * @param index
         */
        public void deleteByIndex(int index) {
            if (index < 1 || index > getLength()) {
                System.out.println("插入的位置不合法。");
                return;
            }

            int count = 1;//记录位置
            temp = head;
            while (temp.next != null) {
                if (index == count++) {
                    temp.next = temp.next.next;
                    return;
                }
                temp = temp.next;
            }

        }

        /**
         * 从头到尾打印节点
         */
        public void printListFromHead() {
            temp = head;
            while (temp.next != null) {
                System.out.print("{" + temp.next.data + "}");
                temp = temp.next;
            }
            System.out.println();

        }


    }

    public static void main(String[] args)
    {
        LinkListDemo list = new LinkListDemo();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.printListFromHead();
        list.addNodeByIndex(3,2.8);
        list.printListFromHead();
        list.deleteByIndex(3);
        list.printListFromHead();
        System.out.println(list.getLength());
    }
}

