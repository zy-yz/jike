package com.zy.jike.数据结构与算法之美.基本数据结构.linkedlist;

import java.util.LinkedList;

/**
 * @ClassName LinkedListAlgo
 * @Description * 1) 单链表反转
 *  * 2) 链表中环的检测
 *  * 3) 两个有序的链表合并
 *  * 4) 删除链表倒数第n个结点
 *  * 5) 求链表的中间结点
 * @Author peppers
 * @Date 2020/3/22$
 * @Version 1.0
 **/
public class LinkedListAlgo {
    private LinkedListAlgo.Node head= null;
    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    /**
     *
     * @param [list]
     * @return com.zy.jike.数据结构与算法之美.基本数据结构.linkedlist.LinkedListAlgo.Node
     */
    public static Node reverse(Node list){
        Node curr = list,pre = null;
        while (curr != null){
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * @Description   检测环
     * @param [list]
     * @return boolean
     */
    public static boolean checkCircle(Node list){
        if(list ==null){
            return false;
        }
        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


      /**
       * @Description       合并两个链表
       * @param [l1, l2]
       * @return com.zy.jike.数据结构与算法之美.基本数据结构.linkedlist.LinkedListAlgo.ListNode
       */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        //利用哨兵结点简化实现难度
        ListNode soldier = new ListNode(0);
        ListNode p = soldier;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        return soldier.next;
    }

    /**
     * @Description  删除倒数第k个结点
     * @param [list, k]
     * @return com.zy.jike.数据结构与算法之美.基本数据结构.linkedlist.LinkedListAlgo.Node
     */
    public static Node deleteLastKth(Node list,int k){
        Node fast = list;
        int i=1;
        while(fast != null && i < k){
            fast = fast.next;
            ++i;
        }
        if(fast == null){
            return list;
        }
        Node slow = list;
        Node prev = null;
        while (fast.next != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if(prev == null){
            list = list.next;
        }else {
            prev.next = prev.next.next;
        }

        return list;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * @Description    寻找中间结点
     * @param [list]
     * @return com.zy.jike.数据结构与算法之美.基本数据结构.linkedlist.LinkedListAlgo.Node
     */
    public static Node findMiddleNode(Node list){
        if (list == null){
            return null;
        }
        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }



    public static void main(String[] args) {


    }
}
