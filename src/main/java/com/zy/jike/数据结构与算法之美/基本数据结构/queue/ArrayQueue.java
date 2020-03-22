package com.zy.jike.数据结构与算法之美.基本数据结构.queue;

/**
 * @ClassName ArrayQueue
 * @Description 用数组实现队列
 * @Author peppers
 * @Date 2020/3/22$
 * @Version 1.0
 **/
public class ArrayQueue {
    //数组，items，数组大小，n
    private String[] items;
    private int n =0;
    //head表示对头下标，tail表示队尾下标
    private int head = 0;
    private  int tail = 0;

    //申请一个大小为capacity的数组
    public ArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item){
        //如果tail == n表示队列已经满了
        if(tail == n){
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    //出队
    public String dequeue(){
        if(head == tail){
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }
    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
