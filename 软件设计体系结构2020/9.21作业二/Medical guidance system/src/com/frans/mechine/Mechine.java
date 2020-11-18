package com.frans.mechine;

import java.util.*;

public class Mechine {
    private int mid;
    private boolean isIdle;
    private Map<Integer, Integer> project2time = new HashMap<>();
    private List<Integer> suffers = new ArrayList<>();
    private Map<Integer, Integer> queue = new HashMap<>(); //<项目名称, 执行时刻> 的执行队列

    public Mechine(boolean isIdle) {
        this.mid = ++count;
        this.isIdle = isIdle;
    }

    public Mechine() {
        this.mid = ++count;
    }

    public Integer getMid() {
        return mid;
    }

    public boolean isIdle() {
        return isIdle;
    }

    public void setIdle(boolean idle) {
        isIdle = idle;
    }

    public Map<Integer, Integer> getProject2time() {
        return project2time;
    }

    public List<Integer> getSuffers() {
        return suffers;
    }

    public Map<Integer, Integer> getQueue() {
        return queue;
    }

    private static int count = -1;

    @Override
    public String toString() {
        return "Mechine{" +
                "mid=" + mid +
                ", isIdle=" + isIdle +
                ", project2time=" + project2time +
                ", suffers=" + suffers +
                ", queue=" + queue +
                '}';
    }
}
