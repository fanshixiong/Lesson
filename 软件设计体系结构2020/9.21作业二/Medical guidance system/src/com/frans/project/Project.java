package com.frans.project;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {
    private Integer pid;
    private boolean isEmpty;
    private List<Integer> mechines = new ArrayList<>();
    private List<Integer> preprojects = new ArrayList<>();
    private Map<Integer, Integer> queue = new HashMap<>(); // <患者, 执行时刻>的执行队列

    public Project(boolean isEmpty) {
        this.pid = ++count;
        this.isEmpty = isEmpty;
    }
    public Project() {
        this.pid = ++count;
    }

    public Integer getPid() {
        return pid;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public List<Integer> getMechines() {
        return mechines;
    }

    public List<Integer> getPreprojects() {
        return preprojects;
    }

    public Map<Integer, Integer> getQueue() {
        return queue;
    }

    private static int count = -1;

    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", isEmpty=" + isEmpty +
                ", mechines=" + mechines +
                ", preprojects=" + preprojects +
                ", queue=" + queue +
                '}';
    }
}
