package com.deputy.coding_challenge.controller;

import com.deputy.coding_challenge.model.Role;
import com.deputy.coding_challenge.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages role subordination operations for users.
 */
public class SubordinateManager {

    private List<Role> roles;
    private List<User> users;

    public SubordinateManager(List<Role> roles, List<User> users) {
        this.roles = roles;
        this.users = users;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Returns the un-ordered list of subordinate users for the specified user.
     *
     * @param userId the id of the user to look for subordinates for
     *
     * @return the list of subordinate users
     *
     * @throws Exception if the roles or users are undefined or if the user id is not found
     */
    public List<User> getSubordinates(int userId) throws Exception {
        //early returns, avoid null pointer exceptions
        if (roles == null || roles.isEmpty()) {
            throw new Exception("Roles are undefined or empty, use 'setRoles(List<Role> roles)'");
        }
        if (users == null || users.isEmpty()) {
            throw new Exception("Users are undefined or empty, use 'setUsers(List<User> users)'");
        }

        //find user with id in list
        User user = getUserFromId(userId);
        if (user == null) {
            throw new Exception("User " + userId + " not found");
        }

        //get role for that user
        Integer userRoleId = user.getRole();

        //get list of subordinate role-ids for that role
        List<Integer> subordinateIdList = new ArrayList<>();
        recursivelyPopulateSubordinateRoleList(subordinateIdList, userRoleId);

        //filter users on role
        return getUsersWithRoles(subordinateIdList);
    }

    /**
     * Returns the user with the specified id from the users list, or null.
     *
     * @param userId the id of the user to look for
     *
     * @return the user or null
     */
    public User getUserFromId(int userId) {
        return users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst().orElse(null);
    }

    /**
     * Use recursion to append specified parent role id's
     *
     * @param roleIds  the list or role ids to append subordinate role ids to
     * @param parentId the id of the parent role for which to look for subordinates
     */
    private void recursivelyPopulateSubordinateRoleList(List<Integer> roleIds, Integer parentId) {
        //parse roles to filter roles with parent id
        List<Role> subordinateRoles = roles.stream()
                .filter(role -> role.getParent().equals(parentId))
                .collect(Collectors.toList());
        //recursively add child role-id to rolesId
        subordinateRoles.forEach(role -> {
            Integer roleId = role.getId();
            roleIds.add(roleId);
            recursivelyPopulateSubordinateRoleList(roleIds, roleId);
        });
    }

    /**
     * Return the list of users whose roles are in the specified list of role ids.
     *
     * @param roleIds the list of role ids to filter the users on
     *
     * @return the filtered list of users
     */
    private List<User> getUsersWithRoles(List<Integer> roleIds) {
        return users.stream()
                .filter(u -> roleIds.contains(u.getRole()))
                .collect(Collectors.toList());
    }
}
