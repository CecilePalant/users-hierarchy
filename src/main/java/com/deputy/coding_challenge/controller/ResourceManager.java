package com.deputy.coding_challenge.controller;

import com.deputy.coding_challenge.model.Role;
import com.deputy.coding_challenge.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResourceManager {

    private static final String ROLES_JSON = "roles.json";
    private static final String USERS_JSON = "users.json";

    private static final Gson gson = new Gson();

    public static List<Role> getRoles() throws FileNotFoundException {
        String resourceFile = ResourceManager.class.getClassLoader().getResource(ROLES_JSON).getFile();
        Type listType = new TypeToken<ArrayList<Role>>() {
        }.getType();
        return gson.fromJson(new FileReader(resourceFile), listType);
    }

    public static List<User> getUsers() throws FileNotFoundException {
        String resourceFile = ResourceManager.class.getClassLoader().getResource(USERS_JSON).getFile();
        Type listType = new TypeToken<ArrayList<User>>() {
        }.getType();
        return gson.fromJson(new FileReader(resourceFile), listType);
    }
}
