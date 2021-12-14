package com.bank.login;

public class Usertable {
    private int id;
    private String user_name;
    private Long user_mob;

    public Usertable( String user_name, Long user_mob) {
        this.user_name = user_name;
        this.user_mob = user_mob;
    }
    public Usertable( int id,String user_name) {
        this.user_name = user_name;
        this.id = id;
    }
    public Usertable( int id) {
        this.id = id;
    }
    public Usertable(  Long user_mob) {
        this.user_name = user_name;
        this.user_mob = user_mob;
    }
    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public Long getUser_mob() {
        return user_mob;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_mob(Long user_mob) {
        this.user_mob = user_mob;
    }
}
