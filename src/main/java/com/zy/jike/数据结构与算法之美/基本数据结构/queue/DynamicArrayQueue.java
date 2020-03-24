package com.zy.jike.数据结构与算法之美.基本数据结构.queue;

/**
 * @ClassName DynamicArrayQueue
 * @Description TODO
 * @Author peppers
 * @Date 2020/3/23$
 * @Version 1.0
 **/
public class DynamicArrayQueue {
    //数组 items，数组大小 n
    private String[] items;

    private int n = 0;

    //head表示对头下标，tail表示队尾
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队操作，将item放入队尾
    public boolean enqueue(String item){
        //tail == n 表示队列末尾没有空间了
        if(tail == n){
            if(head == 0){
                return false;
            }
            //数据搬移
            for(int i = head;i<tail;i++){
                items[i-head] = items[i];
            }
            //搬移完之后重新跟新head和tail
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    //出对
    public String dequeue(){
        //如果head== tail表示队列为空
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

    public static void main(String[] args) {
        DynamicArrayQueue test = new DynamicArrayQueue(5);
        test.dequeue();
        test.printAll();
        test.enqueue("5");
        test.enqueue("6");
        test.enqueue("7");
        test.enqueue("a");
        test.enqueue("b");
        test.enqueue("c");
        test.printAll();


    }
}
