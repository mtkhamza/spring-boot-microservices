package ma.cloud.security.service;

import ma.cloud.security.entities.Role;
import ma.cloud.security.entities.User;
import ma.cloud.security.repositories.RoleRepository;
import ma.cloud.security.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    public AccountServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = userRepository.findByUsername(userName);
        Role role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }
    @Override
    public User loadUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }
    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}