package com.zy.jike.数据结构与算法之美.基本数据结构.search;

/**
 * @ClassName Bsearch
 * @Description 二分查找
 * 1.二分查找依赖的是顺序表结构，就是数组
 * 2.针对的是有序数据
 * 3.数据量太小不适合二分查找
 * 4.数据量太大也不适合二分查找
 * @Author peppers
 * @Date 2020/3/28
 * @Version 1.0
 **/
public class Bsearch {

    /**
     * @Description       利用递归实现二分查找
     * @param [a, n, val]
     * @return int
     */
    public int bsearch(int[] a,int n,int val){
        return bsearchInternally(a,0,n-1,val);
    }
    private int bsearchInternally(int[] a,int low,int high,int value){
        if(low > high){
            return -1;
        }

        int mid = low + ((high - low) >>1);
        if(a[mid] == value){
            return mid;
        }else if(a[mid] < value){
            return bsearchInternally(a,mid+1,high,value);
        }else {
            return bsearchInternally(a,low,mid-1,value);
        }
    }

    /**
     * @Description     最简单的实现二分查找算法
     * @param [a, n, value]
     * @return int
     */
    public int search1(int[] a,int n,int value){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = (low + high) /2;
            if(a[mid] == value){
                return mid;
            }else if(a[mid]< value){
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return -1;
    }


    /**
     * @Description    变体①：查找第一个值等于给定值的元素
     * @param [a, n, value]
     * @return int
     */
    public int search2(int[] a,int n,int value){
        int low = 0;
        int high = n-1;
        while(low <=high){
            int mid = low +((high - low) >>1);
            if(a[mid] > value){
                high = mid -1;
            }else if(a[mid] < value){
                low = mid + 1;
            }else {
                if((mid == 0) || (a[mid -1] != value)){
                    return mid;
                }else {
                    high = mid - 1;
                }
            }
        }
            return -1;
    }

    /**
     * @Description   查找最后一个值等于给定值的元素
     * @param [a, n, value]
     * @return int
     */
    public int search3(int[] a,int n,int value){
        int low=0;
        int high = n - 1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value){
                high = mid - 1;
            }else if(a[mid] < value){
                low = mid + 1;
            }else {
                if((mid == n-1) || (a[mid] + 1 != value))
                    return mid;
                else low = mid + 1;
            }
        }

        return -1;

    }

    /**
     * @Description       查找第一个大于等于给定值的元素
     * @param [a, n, value]
     * @return int
     */
    public int search4(int[] a,int n,int value){

        int low = 0;
        int high = n -1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(a[mid]>= value){
                if((mid == 0) || ( a[mid - 1] < value)){
                    return mid;
                }else {
                    high = mid - 1;
                }
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int a[] = {1,2,2,2,2,6,7,8,9};
        int n = a.length;
        int value = 2;
        Bsearch bsearch1 = new Bsearch();

        System.out.println(bsearch1.search2(a,n,value));
    }
}
