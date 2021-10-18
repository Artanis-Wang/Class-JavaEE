package server.demo.domain;

public class User {
    private Integer id;
    private String username;
    private String token;
    private String pwd;
    public User(String username, String pwd)
    {
        this.pwd = pwd;
        this.username = username;
        this.token = "";
    }
    public void setToken(String token){this.token = token;}
    public String getToken(){return token;}
    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id;}
    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

    public static User admin = new User("admin","123456");
}
