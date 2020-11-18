package pojo;

public class Teacher {
    public String id;
    public String name;
    public String sex;
    public int age;
    public String job;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Teacher(String id, String name, String sex, int age, String job) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.job = job;
    }
}
