package com.zy.jike.数据结构与算法之美.基本数据结构.stack;

/**
 * @ClassName StackBasedOnLinkedList
 * @Description 基于链表实现的栈
 * @Author peppers
 * @Date 2020/3/22$
 * @Version 1.0
 **/
public class StackBasedOnLinkedList {
    private static class Node {
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
    private Node top = null;

    public void push(int value){
        Node newNode = new Node(value,null);
        //判断是否栈空
        if(top == null){
            top = newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
    }
    public int pop() {
        if (top == null) return -1;
        int value = top.data;
        top = top.next;
        return value;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
}
