package ma.emsi.jpaapp.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.emsi.jpaapp.entities.Role;
import ma.emsi.jpaapp.entities.User;
import ma.emsi.jpaapp.repositories.RoleRepository;
import ma.emsi.jpaapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());

        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {

        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
            User user= findUserByUserName(username);
            Role role=findRoleByRoleName(roleName);
           if(user.getRoles()!=null)
            user.getRoles().add(role);
           role.getUsers().add(user);

    }

    @Override
    public User authenticate(String userName, String password) {
        User user=userRepository.findByUsername(userName);
        if(user==null) throw new RuntimeException("BAD CREDENTIALS");
        if(user.getPassword().equals(password)){
            return null;
        }
        throw new RuntimeException("BAD CREDENTIALS");
    }
    //userRepository.save(user);

}
