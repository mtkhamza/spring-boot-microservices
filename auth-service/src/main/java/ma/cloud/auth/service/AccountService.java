package ma.cloud.auth.service;

import ma.cloud.auth.entities.AppRole;
import ma.cloud.auth.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addUser(AppUser user);
    AppRole addRole(AppRole role);
    void addRoleToUser(String userName, String roleName);
    AppUser loadUserByUserName(String userName);
    List<AppUser> listUsers();
}
