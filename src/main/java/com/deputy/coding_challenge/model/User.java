package com.deputy.coding_challenge.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("Id")
    private Integer id;

    @SerializedName("Name")
    private String name;

    @SerializedName("Role")
    private Integer role;

    public User() {
    }

    public User(Integer id, String name, Integer role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
