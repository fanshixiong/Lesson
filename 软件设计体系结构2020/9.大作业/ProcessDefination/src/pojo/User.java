package pojo;

public class User {
      public String id;
      public String name;
      public String password;
      int identity;

    public User(String id, String name, String password, int identity) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.identity = identity;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
}
