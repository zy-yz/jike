package com.zy.jike.数据结构与算法之美.基本数据结构.heap;

import java.util.PriorityQueue;

/**
 * @ClassName MidNumCount
 * @Description 求中位数
 * @Author peppers
 * @Date 2020/3/29
 * @Version 1.0
 **/
public class MidNumCount {

    //求中位数的信息
    public static final MidNumCount INSTANCE = new MidNumCount();

    //大顶堆，用来存储前半部分的数据，如果完整为100，那么存储的为0-50
    private PriorityQueue<Integer> firstBigHeap =
            new PriorityQueue<>(
                    51,
                    (o1,o2) ->{
                        if(o1<o2){
                            return 1;
                        }else if(o1 > o2){
                            return -1;
                        }
                        return 0;
                    });
    /** 小顶堆,用来存储后半部分的数据，如果完整为100,那此存储的为51-100 */
    private PriorityQueue<Integer> afterLittleHeap = new PriorityQueue<>(51);

    /**元素个数*/
    private int count;

    /**
     * @Description   插入数据
     * @param [num]   当前动态的数据集
     * @return void
     */
    public void putNum(int num){

        count++;

        //1.如果堆为空，就插入到大顶堆中
        if(firstBigHeap.isEmpty() && afterLittleHeap.isEmpty()){
            firstBigHeap.offer(num);
            return;
        }

        //如果数据当前元素比大顶堆中的元素大，就插入到小顶堆中
        if (firstBigHeap.peek() < num){
            afterLittleHeap.offer(num);
        }
        //如果元素的数据比大顶堆中的元素小，则插入大顶堆中
        else {
            firstBigHeap.offer(num);
        }

        int countValue = count / 2;

        // 如果大顶堆中的数据超过了中位数，则需要要移动,
        // 因为大顶堆中存储的数据为n/2+1个当n为奇数的情况下，所以每次取数，仅返回大顶堆中的数据即可
        if(firstBigHeap.size() > countValue){
            move(firstBigHeap,afterLittleHeap,afterLittleHeap.size() - countValue);
            return;
        }
        //如果小顶堆超过了中位数,也需要移动
        if(afterLittleHeap.size() > countValue){
            move(afterLittleHeap,firstBigHeap,afterLittleHeap.size() - countValue);
            return;
        }
    }

    /**
     * @Description     返回中位数的数据
     * @param []
     * @return int
     */
    public int getMidValue(){
        return firstBigHeap.peek();
    }

    private void move(PriorityQueue<Integer> src,PriorityQueue<Integer> out,int runNum){
        for (int i=0;i<runNum;i++){
            out.offer(src.poll());
        }
    }

    public static void main(String[] args) {
        MidNumCount numCount = new MidNumCount();

        for (int i=1;i<=100;i++){
            numCount.putNum(i);
        }
        System.out.println(numCount.getMidValue());
    }
}
