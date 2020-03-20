package com.zy.jike.数据结构与算法之美.基本数据结构.linkedlist;

import java.util.Scanner;

public class LRUBaseLinkedList<T> {

     class SNode<T>{
         private T element;

         private SNode next;

         public SNode(T element){
             this.element = element;
         }

         public SNode(T element,SNode next){
             this.element = element;
             this.next = next;
         }
         public SNode() {
             this.next = null;
         }

         public T getElement() {
             return element;
         }

         public void setElement(T element) {
             this.element = element;
         }

         public SNode getNext() {
             return next;
         }

         public void setNext(SNode next) {
             this.next = next;
         }

    }
    //默认链表容量
    private final static Integer DEFAULT_CAPACITY = 10;

    //头结点
    private SNode<T> headNode;

    //链表长度
    private Integer length;

    //链表容量
    private Integer capacity;

    public LRUBaseLinkedList(){
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity){
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data){
        SNode preNode = findPreNode(data);

        //链表中存在，删除原数据，在插入到链表头部
        if(preNode != null){
            deleteElemOptim(preNode);
            insertElemAtBegin(data);

        }else {
            if(length >= this.capacity){
                //删除尾结点
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }

    /**
     * 删除preNode结点下一个元素*/
    private void deleteElemOptim(SNode preNode){
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**链表头部插入结点*/
    private void insertElemAtBegin(T data){
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data,next));
        length++;
    }

    /**
     * 删除尾结点
     * */
    private void deleteElemAtEnd(){
        SNode ptr = headNode;
        //空链表直接返回
        if(ptr.getNext() == null){
            return;
        }
        //倒数第二个结点
        while (ptr.getNext().getNext() != null){
            ptr = ptr.getNext();
        }
        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    private SNode findPreNode(T data){
        SNode node = headNode;
        while (node.getNext() != null){
            if(data.equals(node.getNext().getElement())){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }
    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }

}
