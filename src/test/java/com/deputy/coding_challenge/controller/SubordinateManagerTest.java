package com.deputy.coding_challenge.controller;

import com.deputy.coding_challenge.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Testing class for subordinate manager
 */
class SubordinateManagerTest {

    private static SubordinateManager subordinateManager;

    @BeforeAll
    static void initialize() throws Exception {
        subordinateManager = new SubordinateManager(ResourceManager.getRoles(), ResourceManager.getUsers());
    }

    @Test
    void testException() throws Exception {
        // should throw an exception when user id is not in list of users
        Assertions.assertThrows(Exception.class, () -> {
            subordinateManager.getSubordinates(0);
        });
    }

    @Test
    void testAdminSubordinates() throws Exception {
        //User with id 1 has 4 subordinates, one of which should be user with id 4
        List<User> subordinates = subordinateManager.getSubordinates(1);
        Assertions.assertEquals(4, subordinates.size());
        Assertions.assertTrue(subordinates.contains(subordinateManager.getUserFromId(4)));
    }

    @Test
    void testSupervisorSubordinates() throws Exception {
        //user with id 3 has 2 subordinates, one of which should be user with id 5
        List<User> subordinates = subordinateManager.getSubordinates(3);
        Assertions.assertEquals(2, subordinates.size());
        Assertions.assertTrue(subordinates.contains(subordinateManager.getUserFromId(5)));
    }

    @Test
    void testEmployeeSubordinates() throws Exception {
        //user with id 2 has no subordinates
        List<User> subordinates = subordinateManager.getSubordinates(2);
        Assertions.assertTrue(subordinates.isEmpty());
    }
}