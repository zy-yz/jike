package com.zy.jike.数据结构与算法之美.基本数据结构.heap.highTimeSchedule.pojo;

/**
 * @ClassName ScheduleBusi
 * @Description 高性能的定时任务实现实体
 * @Author peppers
 * @Date 2020/3/29
 * @Version 1.0
 **/
public class ScheduleBusi {

    //定时运行的时间点
    private long runTime;

    //定时任务的时间点
    private Runnable runable;

    public ScheduleBusi(long runTime, Runnable runable) {
        this.runTime = runTime;
        this.runable = runable;
    }

    public long getRunTime() {
        return runTime;
    }

    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    public Runnable getRunable() {
        return runable;
    }

    public void setRunable(Runnable runable) {
        this.runable = runable;
    }
}
