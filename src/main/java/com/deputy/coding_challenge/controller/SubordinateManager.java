package com.deputy.coding_challenge.controller;

import com.deputy.coding_challenge.model.Role;
import com.deputy.coding_challenge.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubordinateManager {

    private List<Role> roles;
    private List<User> users;

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getSubordinates(int userId) throws Exception {
        //find user with id in list
        User user = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        if (user == null) {
            throw new Exception("User " + userId + " not found");
        }

        //get role for that user
        Integer userRoleId = user.getRole();

        //get list of subordinate role-ids for that role
        List<Integer> subordinateIds = new ArrayList<>();
        addSubordinate(subordinateIds, userRoleId);

        //filter users on role
        return users.stream().filter(u -> subordinateIds.contains(u.getRole())).collect(Collectors.toList());
    }

    private void addSubordinate(List<Integer> roleIds, Integer parentId) {
        //parse roles to filter roles with parent id
        List<Role> subordinateRoles = roles.stream().filter(role -> role.getParent().equals(parentId)).collect(Collectors.toList());
        //add role ids to rolesIds
        //for each role, call addSubordinates(roleIds, roles, parentId)
        subordinateRoles.forEach(role -> {
            Integer roleId = role.getId();
            roleIds.add(roleId);
            addSubordinate(roleIds, roleId);
        });
    }
}
