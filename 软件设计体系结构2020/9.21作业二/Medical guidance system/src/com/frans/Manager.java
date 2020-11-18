package com.frans;

import com.frans.mechine.Mechine;
import com.frans.project.Project;

import java.util.*;

public class Manager {
    private static List<Mechine> mechines = new ArrayList<>();
    private static List<Project> projects = new ArrayList<>();

    public List<Mechine> getMechines() {
        return mechines;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public static void init(){
        for(int i = 0; i < Constants.PROJECTS_NUMS; i++) {
            Project project = new Project();
            projects.add(project);
        }

        for (int i = 0; i < Constants.MECHINES_NUMS; i++) {
            Mechine mechine = new Mechine();
            mechines.add(mechine);
        }
    }
    private static void setProjects() {
        //Fast
        projects.get(0).setEmpty(true);
        projects.get(1).setEmpty(false);
        projects.get(2).setEmpty(true);

        //Mechine
        //p[0]
        projects.get(0).getMechines().add(0);
        projects.get(0).getMechines().add(2);
        //p[1]
        projects.get(1).getMechines().add(1);
        //p[2]
        projects.get(2).getMechines().add(0);
        projects.get(2).getMechines().add(1);
        projects.get(2).getMechines().add(2);


        //preprojects
        //pre[0] = 2;
        projects.get(0).getPreprojects().add(2);


        System.out.println("====================>Projects Info");
        for (Project project : projects) {
            System.out.println(project.toString());
        }
        System.out.println();
        /*
        for (Project project : projects) {
            System.out.println(project + " " + "是否空腹： " + project.isEmpty() + project.getPid() + "机器：");
            for (Integer mechine : project.getMechines()) {
                System.out.println(mechine + " " + mechines.get(mechine).getMid());
            }
        }
        */
    }

    private static void setMechines() {
        //map -> <project, time>
        mechines.get(0).getProject2time().put(0, 7);
        mechines.get(0).getProject2time().put(1, 4);
        mechines.get(0).getProject2time().put(2, 3);

        mechines.get(1).getProject2time().put(1, 5);
        mechines.get(1).getProject2time().put(2, 8);

        mechines.get(2).getProject2time().put(2, 2);

        System.out.println("====================>Mechines Info");
        for (Mechine mechine : mechines) {
            System.out.println(mechine.toString());
        }
        System.out.println();
        /*
        //遍历hashmap
        // manager.getMechines().get(0).getProject2time();
        for (Mechine mechine : mechines) {
            System.out.println(mechine + " " + mechine.getMid() + " 项目， 时间");
            Map<Integer, Integer> project2time = mechine.getProject2time();
            Iterator<Map.Entry<Integer, Integer>> it = project2time.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<Integer, Integer> entry = it.next();
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(projects.get(key).getPid() + " " + key + " " +  value);
            }
        }
        */


        /*
        Mechine mechine1 = new Mechine1();
        List<Integer> times = new ArrayList<>();
        times.add(3);
        mechine1.setMtimes(times);
        List<Integer> mtimes = mechine1.getMtimes();
        for (Integer mtime : mtimes) {
            System.out.println(mtime);
        }
        */
    }

    public static void manager() {
        init();
        setMechines();
        setProjects();
    }
}
