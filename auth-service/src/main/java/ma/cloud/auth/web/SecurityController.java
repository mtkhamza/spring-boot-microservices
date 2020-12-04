package ma.cloud.auth.web;

import ma.cloud.auth.entities.AppRole;
import ma.cloud.auth.entities.AppUser;
import ma.cloud.auth.entities.RoleUserForm;
import ma.cloud.auth.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class SecurityController {

    private AccountService accountService;

    public SecurityController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/users")
    public List<AppUser> users() {
        return accountService.listUsers();
    }

    @PostMapping("/users")
    public AppUser saveUser(@RequestBody AppUser user) {
        return accountService.addUser(user);
    }

    @PostMapping("/roles")
    public AppRole saveRole(@RequestBody AppRole role) {
        return accountService.addRole(role);
    }

    @PostMapping("/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm) {
        accountService.addRoleToUser(roleUserForm.getUserName(), roleUserForm.getRoleName());
    }

}
