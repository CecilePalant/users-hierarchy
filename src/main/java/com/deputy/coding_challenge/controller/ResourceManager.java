package com.deputy.coding_challenge.controller;

import com.deputy.coding_challenge.model.Role;
import com.deputy.coding_challenge.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Uses google Gson library to deserialize json data files from the project's resource folder
 */
public class ResourceManager {

    private static final String ROLES_JSON = "roles.json";
    private static final String USERS_JSON = "users.json";

    private static final Gson gson = new Gson();

    /**
     * Returns a list of roles as described in the roles.json file in the project's resource folder
     *
     * @return the list of roles
     *
     * @throws FileNotFoundException if the file was not found or malformed
     */
    public static List<Role> getRoles() throws Exception {
        try {
            String resourceFile = ResourceManager.class.getClassLoader().getResource(ROLES_JSON).getFile();
            Type listType = new TypeToken<ArrayList<Role>>() {
            }.getType();
            return gson.fromJson(new FileReader(resourceFile), listType);
        } catch (FileNotFoundException | NullPointerException ex) {
            throw new Exception("Failed get roles.json", ex);
        } catch (JsonIOException | JsonSyntaxException e) {
            throw new Exception("Failed deserialize roles from roles.json", e);
        }
    }

    /**
     * Returns a list of users as described in the users.json file in the project's resource folder
     *
     * @return the list of users
     *
     * @throws FileNotFoundException if the file was not found or malformed
     */
    public static List<User> getUsers() throws Exception {
        try {
            String resourceFile = ResourceManager.class.getClassLoader().getResource(USERS_JSON).getFile();
            Type listType = new TypeToken<ArrayList<User>>() {
            }.getType();
            return gson.fromJson(new FileReader(resourceFile), listType);
        } catch (FileNotFoundException | NullPointerException ex) {
            throw new Exception("Failed get users.json", ex);
        } catch (JsonIOException | JsonSyntaxException e) {
            throw new Exception("Failed deserialize users from users.json", e);
        }
    }
}
