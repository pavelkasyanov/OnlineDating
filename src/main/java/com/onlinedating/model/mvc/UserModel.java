package com.onlinedating.model.mvc;

import com.onlinedating.model.*;

import java.util.Set;

/**
 * Created by Aver on 25.06.2015.
 */
public class UserModel {
    private int UserID;
    private String User_login;
    private String User_Name;
    private String User_Inf;
    private String Sex;

    public int getUserID() {
        return UserID;
    }
    public void setUserID(int id) {
        this.UserID = id;
    }
    public String getUser_Name() {
        return User_Name;
    }
    public void setUser_Name(String name) {
        this.User_Name = name;
    }

    public String getUser_login() {
        return User_login;
    }
    public void setUser_login(String login) {
        this.User_login = login;
    }
    public String getUser_Inf() {
        return User_Inf;
    }
    public void setUser_Inf(String inf) {
        this.User_Inf = inf;
    }
    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }



    @Override
    public String toString() {
        return "User{" +
                "User_login='" + User_login + '\'' +
                ", User_Name='" + User_Name + '\'' +
                '}';
    }
}
