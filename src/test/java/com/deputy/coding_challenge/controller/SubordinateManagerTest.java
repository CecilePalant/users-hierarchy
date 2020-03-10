package com.deputy.coding_challenge.controller;

import com.deputy.coding_challenge.model.Role;
import com.deputy.coding_challenge.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SubordinateManagerTest {

    @Test
    void getSubordinates() throws Exception {

        //load resources
        List<Role> roles = ResourceManager.getRoles();
        List<User> users = ResourceManager.getUsers();

        //set up subordinate manager with objects
        SubordinateManager subordinateManager = new SubordinateManager();
        subordinateManager.setRoles(roles);
        subordinateManager.setUsers(users);

        // should throw an exception when user id is not in list of users
        Assertions.assertThrows(Exception.class, () -> {
            subordinateManager.getSubordinates(0);
        });

        List<User> subordinates = subordinateManager.getSubordinates(1);
        Assertions.assertEquals(4, subordinates.size());

        subordinates = subordinateManager.getSubordinates(3);
        Assertions.assertEquals(2, subordinates.size());
    }
}