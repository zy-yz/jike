package com.zy.jike.数据结构与算法之美.基本数据结构;

public class Array {

    //定义整型数据data保存数据
    public int data[];

    //定义数组长度
     private int n;

     //实际个数
    private int count;

    //构造方法，定义数组大小
    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        //一开始没有数所以设置为0
        this.count = 0;
    }

    //根据索引找到数据中的元素并返回
    public int find(int index){
        if(index <0 || index >=count){
            return -1;
        }
        return data[index];
    }

    //插入元素;头部插入，尾部插入
    public boolean insert(int index,int value){
        if(index <0 || index >count){
            return false;
        }
        if (count==n){
            System.out.println("空间已满");
            return false;
        }
        //位置合法，可以插入
        for (int i=count;i>index;--i){
            data[i] = data[i-1];
        }
        data[index] = value;
        ++count;
        return true;
    }
    //根据索引，删除数组中的元素
    public boolean delete(int index){
        if(index <0 || index >=count){
            return false;
        }
        for (int i = index+1;i<count;i++){
            data[i-1] = data[i];
        }
        --count;
        return true;
    }
    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();
        array.delete(3);
        array.printAll();
    }
}
