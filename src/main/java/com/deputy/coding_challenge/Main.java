package com.deputy.coding_challenge;

import com.deputy.coding_challenge.controller.ResourceManager;
import com.deputy.coding_challenge.controller.SubordinateManager;
import com.deputy.coding_challenge.model.Role;
import com.deputy.coding_challenge.model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        //load json file resources
        List<Role> roles = ResourceManager.getRoles();
        List<User> users = ResourceManager.getUsers();

        //set up subordinate manager with objects
        SubordinateManager subordinateManager = new SubordinateManager(roles, users);
//        subordinateManager.setRoles(roles);
//        subordinateManager.setUsers(users);

        int userId = 3;
        List<User> subordinates = subordinateManager.getSubordinates(userId);
        System.out.println("List of subordinates for user with id " + userId);
        subordinates.forEach(System.out::println);
    }
}
