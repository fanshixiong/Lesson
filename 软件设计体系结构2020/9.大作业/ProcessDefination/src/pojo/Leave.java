package pojo;

public class Leave {
    public String createtime;
    public String creator;
    public String reason;
    public String teacher1;
    public String teacher2;

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTeacher1() {
        return teacher1;
    }

    public void setTeacher1(String teacher1) {
        this.teacher1 = teacher1;
    }

    public String getTeacher2() {
        return teacher2;
    }

    public void setTeacher2(String teacher2) {
        this.teacher2 = teacher2;
    }

    public Leave(String createtime, String creator, String reason, String teacher1, String teacher2) {
        this.createtime = createtime;
        this.creator = creator;
        this.reason = reason;
        this.teacher1 = teacher1;
        this.teacher2 = teacher2;
    }
}
