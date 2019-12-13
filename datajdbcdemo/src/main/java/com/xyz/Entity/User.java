package com.xyz.Entity;


import org.springframework.beans.factory.annotation.Value;

public class User {

    @Value("100")
    private int id;
    @Value("寒星月冷")
    private String username;
    @Value("艾泽拉斯")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
