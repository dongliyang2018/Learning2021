package com.dong.model;

import com.sun.org.apache.xpath.internal.functions.FuncSubstring;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private Long id;
    private String username;
    private String address;

    private List<Role> roles;

    private Integer enabled;
    private List<String> favorites;

    public User() {}

    public User(Long id, String username, String address) {
        this.id = id;
        this.username = username;
        this.address = address;
    }

    public User(String username, String address, Integer enabled, List<String> favorites) {
        this.username = username;
        this.address = address;
        this.enabled = enabled;
        this.favorites = favorites;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", roles=" + roles +
                ", enabled=" + enabled +
                ", favorites=" + favorites +
                '}';
    }
}
