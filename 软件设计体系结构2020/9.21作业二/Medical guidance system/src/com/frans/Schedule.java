package com.frans;

import com.frans.mechine.Mechine;
import com.frans.project.Project;
import com.frans.suffer.Suffer;

import java.util.*;

public class Schedule implements Runnable{
    private static Manager manager = new Manager();
    private static int T = 0;

    public static Suffer createSuffer() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(100);

        System.out.println("请输入个人信息：");
        System.out.println("姓名：");
        String sname = scanner.nextLine();
        System.out.println("性别：");
        String ssex = scanner.nextLine();
        System.out.println("年龄：");
        int sage = scanner.nextInt();
        System.out.println("是否空腹：（0 空腹 1 非空腹）");
        boolean isFast = scanner.nextInt() == 0 ? true : false;
        System.out.println("请选择项目：（填项目编号, q退出）");
        for (int i = 0; i < Constants.PROJECTS_NUMS; i++) {
            System.out.println(i + ".项目" + (i + 1) + " ");
        }
        List<Integer> integers = new ArrayList<>();
        ArrayList<Integer> projects = new ArrayList<>();
        while (!scanner.hasNext("q")) {
            int id = scanner.nextInt();
            if (manager.getProjects().get(id).isEmpty() == true && isFast != true) {
                System.out.println("检查项目含有空腹项目，请明天空腹检查");
                return null;
            }
            projects.add(id);
        }
        T += random.nextInt(12) + 1;

        return new Suffer(sname, ssex, isFast, T, projects);
    }



    public static void print(Suffer suffer) {
        List<Integer> times = suffer.getPtimes();
        List<Integer> projects = suffer.getProjects();
        List<Integer> mechines = suffer.getMechines();
        if (times.size() == 0) {
            System.out.println("w");
            return;
        }
        System.out.println("序号   项目编号   时间    机器   所需时间");
        for (int i = 0; i < times.size(); i++) {
            System.out.println((i + 1) + "\t\t" + projects.get(i) + "\t\t" + times.get(i) + "\t\t" + mechines.get(i) + "\t\t" + manager.getMechines().get(mechines.get(i)).getProject2time().get(projects.get(i)));
        }
    }

    @Override
    public void run() {

        // List<Suffer> suffers = new ArrayList<>();

        while (true) {
            // 锁
            synchronized (Schedule.class) {
                Suffer suffer = createSuffer();
                if (suffer == null) {
                    continue;
                }
                System.out.println("==============>Suffer Info");
                System.out.println(suffer.toString());
                // suffers.add(suffer);
                suffer.sortProjects();
                schedule(suffer);
                print(suffer);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }
    }
    /**
     * 未做： 线程
     * @param suffer
     */
    public static void schedule(Suffer suffer) {
        List<Integer> projects = suffer.getProjects();

        List<Project> allprojects = manager.getProjects();
        List<Mechine> allmechines = manager.getMechines();

        Integer time = suffer.getStime();

        /*
         * 1. 对于每个项目，找到可以做的机器
         * 2. 对于每个机器的项目队列，找到最小的最长时间
         *      如果当前时间减去项目在机器上的检查时间大于项目进队列的时间，出队列。
         */
        for (Integer project : projects) {
            List<Integer> mechines = allprojects.get(project).getMechines();
            int temp = 0, min_t = 0x3f;
            for (Integer _mechine : mechines) {
                //项目名称和执行时刻执行队列
                Mechine mechine = allmechines.get(_mechine);
                Map<Integer, Integer> projectQueue = mechine.getQueue();
                Iterator<Map.Entry<Integer, Integer>> it = projectQueue.entrySet().iterator();
                int t = 0;
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> entry = it.next();
                    Integer key = entry.getKey();
                    int p = mechine.getProject2time().get(key);
                    Integer value = entry.getValue();
                    if (p <= time - value) {
                        it.remove();
                        continue;
                    }
                    t = Math.max(t, time - value);
                }
                if (min_t > t) {
                    temp = _mechine;
                    min_t = t;
                }
            }
            if (min_t == 0) {
                int tmin_t = 0x3f;
                for (Integer _mechine : mechines) {
                    Integer integer = allmechines.get(_mechine).getProject2time().get(project);
                    if (integer == null) continue;
                    if (tmin_t > integer) {
                        tmin_t = integer;
                        temp = _mechine;
                    }
                }
            }
            int t = min_t == 0 ? time : time + min_t;
            Mechine mechine = allmechines.get(temp);
            mechine.getQueue().put(project, t);
            suffer.getPtimes().add(t);
            suffer.getMechines().add(temp);
            time = t + allmechines.get(temp).getProject2time().get(project);
        }
    }
}
