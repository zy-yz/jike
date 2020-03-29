package com.zy.jike.数据结构与算法之美.基本数据结构.heap.highTimeSchedule;

import java.time.LocalDateTime;

/**
 * @ClassName RunSchedule
 * @Description TODO
 * @Author peppers
 * @Date 2020/3/29
 * @Version 1.0
 **/
public class RunSchedule {

    public static final RunSchedule INSTANCE = new RunSchedule();

    public final long getCurrTime(){
        return System.currentTimeMillis();
    }

    public void runTask(long runtime,Runnable task){
        long currTime;

        while (true){
            currTime = this.getCurrTime();
            long needTime = runtime  - currTime;

            if(needTime > 0){
                try {
                    Thread.sleep(needTime);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }else {
                break;
            }
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("执行时间"+localDateTime.toString());
        task.run();;
    }
}
