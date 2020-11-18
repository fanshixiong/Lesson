package com.frans.suffer;

import com.frans.Constants;
import com.frans.Manager;
import com.frans.project.Project;

import java.util.*;

public class Suffer {
    private Integer sid;
    private String sname;
    private String ssex;
    private boolean isFast;
    private Integer stime;
    private List<Integer> projects = new ArrayList<>();
    private List<Integer> mechines = new ArrayList<>();
    private List<Integer> ptimes = new ArrayList<>();

    public Integer getStime() {
        return stime;
    }

    public void setStime(Integer stime) {
        this.stime = stime;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public List<Integer> getProjects() {
        return projects;
    }

    public List<Integer> getPtimes() {
        return ptimes;
    }

    public void setPtimes(List<Integer> ptimes) {
        this.ptimes = ptimes;
    }

    public boolean getIsFast() {
        return isFast;
    }

    public void setIsFast(boolean isFast) {
        this.isFast = isFast;
    }

    public List<Integer> getMechines() {
        return mechines;
    }

    private static Integer count = 0;

    public Suffer(String sname, String ssex, boolean isFast, Integer stime, List<Integer> projects, List<Integer> ptimes) {
        this.sid = ++count;
        this.sname = sname;
        this.ssex = ssex;
        this.isFast = isFast;
        this.stime = stime;
        this.projects = projects;
        this.ptimes = ptimes;
    }

    public Suffer(String sname, String ssex, boolean isFast, Integer stime, List<Integer> projects) {
        this.sid = ++count;
        this.sname = sname;
        this.ssex = ssex;
        this.isFast = isFast;
        this.stime = stime;
        this.projects = projects;
    }

    public Suffer() {
    }

    public void sortProjects() {
        List<Project> projectList = new Manager().getProjects();
        Collections.sort(this.projects, (a, b) -> {
            if (projectList.get(a).isEmpty() == true && projectList.get(b).isEmpty() == false) {
                return -1;
            }
            if (projectList.get(a).isEmpty() == false && projectList.get(b).isEmpty() == true) {
                return 1;
            }
            return -1;
        });

        topo(projects);
        print();
    }

    private void topo(List<Integer> projects) {

        List<Project> projects1 = new Manager().getProjects();

        int[][] prerequisites = new int[Constants.PROJECTS_NUMS * 10][2];

        boolean[] vis = new boolean[Constants.PROJECTS_NUMS];
        for (boolean vi : vis) {
            vi = false;
        }
        for (int i = 0; i < projects.size(); i++) {
            vis[projects.get(i)] = true;
        }
        int count = 0;
        for (Integer project : projects) {
            List<Integer> preprojects = projects1.get(project).getPreprojects();
            if(preprojects.size() == 0) {
                int[] p = new int[2];
                p[1] = project;
                p[0] = project;
                prerequisites[count++] = p;
                continue;
            }
            for (Integer preproject : preprojects) {
                if (vis[preproject]) {
                    int[] p = new int[2];
                    p[1] = preproject;
                    p[0] = project;
                    prerequisites[count++] = p;
                }
            }
        }
        /*
        for (int i = 0; i < count; i++) {
            System.out.println(prerequisites[i][0] + "  " + prerequisites[i][1]);
        }
        */
        //topo
        if (count == 0) return;
        int[] inDegrees = new int[count];
        for (int i = 0; i < count; i++) {
            int[] p = prerequisites[i];
            if(p[0] == p[1]) inDegrees[p[0]] = 0;
            else inDegrees[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }
        int[] res = new int[count];
        count = 0;
        while (!queue.isEmpty()){
            int curr = queue.poll();
            res[count++] = curr;
            for (int[] p : prerequisites) {
                if(p[1] == p[0]) continue;
                if (p[1] == curr){
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0) queue.offer(p[0]);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ans.add(res[i]);
        }
        this.projects = ans;

    }

    private void print() {
        System.out.println("==========================>topo Projects");
        for (Integer project : projects) {
            System.out.print(project + " ");
        }
        System.out.println();
    }


    /*
    public void sortProjects() {
        Manager manager = new Manager();
        List<Integer> fastprojects = new ArrayList<>();
        List<Integer> plainprojects = new ArrayList<>();
        for (Integer project : projects) {
            if (manager.getProjects().get(project).isEmpty()) {
                fastprojects.add(project);
            } else {
                plainprojects.add(project);
            }
        }

        *//*
        for (Integer fastproject : fastprojects) {
            System.out.print(fastproject);
        }
        for (Integer plainproject : plainprojects) {
            System.out.print(plainproject);
        }
        System.out.println();
        *//*

        List<Integer> aftprojects = new ArrayList<>();
        List<Boolean> vis = new ArrayList<>();
        List<Boolean> count = new ArrayList<>();
        for (int i = 0; i < Constants.PROJECTS.NUMS; i++) {
            if (fastprojects.contains(i)) {
                vis.add(false);
                count.add(true);
            }
            else{
                vis.add(true);
                count.add(false);
            }
        }
        for (Integer fastproject : fastprojects) {
            List<Integer> preprojects = manager.getProjects().get(fastproject).getPreprojects();
            for (Integer preproject : preprojects) {
                if (count.get(preproject) == true && vis.get(preproject) == false) {
                    vis.set(preproject, true);
                    count.set(preproject, false);
                    aftprojects.add(preproject);
                }
            }
            if (count.get(fastproject) == true) {
                aftprojects.add(fastproject);
                count.set(fastproject, false);
                vis.set(fastproject, true);
            }
        }

        vis.clear();
        count.clear();
        for (int i = 0; i < 3; i++) {
            if (plainprojects.contains(i)) {
                vis.add(false);
                count.add(true);
            }
            else{
                vis.add(true);
                count.add(false);
            }
        }
        System.out.println();
        for (Integer plainproject : plainprojects) {
            List<Integer> preprojects = manager.getProjects().get(plainproject).getPreprojects();
            for (Integer preproject : preprojects) {
                if (count.get(preproject) == true && vis.get(preproject) == false) {
                    vis.set(preproject, true);
                    count.set(preproject, false);
                    aftprojects.add(preproject);
                }
            }
            if (count.get(plainproject) == true) {
                aftprojects.add(plainproject);
                count.set(plainproject, false);
                vis.set(plainproject, true);
            }
        }

        this.projects = aftprojects;

        print();
    }*/

    @Override
    public String toString() {
        return "Suffer{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", isFast=" + isFast +
                ", stime=" + stime +
                ", projects=" + projects +
                ", ptimes=" + ptimes +
                '}';
    }
}
