package ma.cloud.auth.service;

import ma.cloud.auth.entities.AppRole;
import ma.cloud.auth.entities.AppUser;
import ma.cloud.auth.repositories.AppRoleRepository;
import ma.cloud.auth.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AppUserRepository userRepository;
    private AppRoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AppUserRepository userRepository, AppRoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser addUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public AppRole addRole(AppRole role) {
        return null;
    }


    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppUser user=userRepository.findByUsername(userName);
        AppRole role=roleRepository.findByRoleName(roleName);
        user.getAppRoles().add(role);
    }

    @Override
    public AppUser loadUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public List<AppUser> listUsers() {
        return userRepository.findAll();
    }
}