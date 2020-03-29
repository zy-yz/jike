package com.zy.jike.数据结构与算法之美.基本数据结构.heap;

import java.util.PriorityQueue;

/**
 * @ClassName TopkCount
 * @Description 利用堆求topK的问题
 * 维护一个大小为K的小顶堆
 * @Author peppers
 * @Date 2020/3/29
 * @Version 1.0
 **/
public class TopkCount {



    /**
     * @Description  求数据中的前K大数据
     * @param [data, k]
     * @return int[]
     */
    public int[] topK(int[] data,int k){

        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (int i=0;i<data.length;i++){
            if(queue.size() < k){
                queue.offer(data[i]);
            }else {
                int value = queue.peek();
                //如果发现数据比堆顶元素大，则加入到小顶堆中
                if(data[i] > value){
                    queue.poll();
                    queue.offer(data[i]);
                }
            }
        }
        int[] result = new int[k];
        int index = 0;
        //遍历完成后，小顶堆的数据就为需要求得的TOPK数据
        while(!queue.isEmpty()){
            result[index++] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        TopkCount topK = new TopkCount();
        int[] data = {1,3,5,4,6,7,4};
        int[] result = topK.topK(data,5);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
