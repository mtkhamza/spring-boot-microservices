package ma.cloud.security.service;


import ma.cloud.security.entities.Role;
import ma.cloud.security.entities.User;

import java.util.List;

public interface AccountService {
    User addUser(User user);
    Role addRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User loadUserByUserName(String userName);
    List<User> listUsers();
}


