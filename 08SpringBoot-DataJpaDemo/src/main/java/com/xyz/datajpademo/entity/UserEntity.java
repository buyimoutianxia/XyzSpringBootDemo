package com.xyz.datajpademo.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_user")
public class UserEntity implements Serializable {

    @Id
    private long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "address")
    private String Address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
