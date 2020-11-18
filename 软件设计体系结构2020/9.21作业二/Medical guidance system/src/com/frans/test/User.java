package com.frans.test;

import java.util.*;

/**
 * 根据order对User排序
 */
public class User { //此处无需实现Comparable接口
    private String name;
    private Integer order;
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getOrder() {
        return order;
    }
    public void setOrder(Integer order) {
        this.order = order;
    }
}

class SynDemo implements Runnable{
    private static int T = 0;

    @Override
    public void run() {
        while(T <= 20){
            synchronized (SynDemo.class){
                for (int i = 0; i < 10; i++) {
                    System.out.println(T++);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        new SynDemo().run();


        /*User user1 = new User();
        user1.setName("a");
        user1.setPrice(11);
        User user2 = new User();
        user2.setName("b");
        user2.setPrice(2);

        Set<User> Hset = new HashSet<User>();
        Hset.add(user2);
        Hset.add(user1);

        List<User> list = new ArrayList<User>();
        list.addAll(Hset);


        Collections.sort(list, new Comparator<User>() {
            public int compare(User arg0, User arg1) {
                System.out.println(arg0.getPrice() + " " + arg1.getPrice() + " " + arg1.getPrice().compareTo(arg0.getPrice()));
                return arg0.getPrice().compareTo(arg1.getPrice());
            }
        });
        for (User u : list) {
            System.out.println(u.getName());
        }*/
    }
}