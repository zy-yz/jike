package com.zy.jike.数据结构与算法之美.基本数据结构.queue;

/**
 * @ClassName CircularQueue
 * @Description 循环队列
 * @Author peppers
 * @Date 2020/3/22
 * @Version 1.0
 **/
public class CircularQueue {

    //数组 items,数组大小n
    private String[] items;
    private int n =0;

    //head表示对头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    //申请一个大小为capacity的数组
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队 队列盼满条件（tail + 1）% n == head
    public boolean enqueue(String item){
        //队列满了
        if((tail + 1) % n == head){
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n ;
        return true;
    }

    //出对
    public String dequeue(){
        //如果head == tail，表示队列为空
        if(head == tail){
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    public void printAll() {
        if (0 == n) return;
        for (int i = head; i % n != tail; i = (i + 1) % n) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

}
