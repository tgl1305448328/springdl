package com.swjd.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "test")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    @TableField("name")
    private String name;
    @TableField("flag")
    private int flag;

    private String passw;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flag=" + flag +
                ", passw='" + passw + '\'' +
                '}';
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public User(int id, String name, int flag, String passw) {
        this.id = id;
        this.name = name;
        this.flag = flag;
        this.passw = passw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public User() {
    }

    public User(int id, String name, String passw) {
        this.id = id;
        this.name = name;
        this.passw = passw;
    }

}
