package ru.ltrnt.littletwi.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ltrnt.littletwi.entity.RoleEntity;
import ru.ltrnt.littletwi.entity.UserEntity;
import ru.ltrnt.littletwi.repository.RoleEntityRepository;
import ru.ltrnt.littletwi.repository.UserEntityRepository;

@Service
public class UserService {

    private RoleEntityRepository roleEntityRepository;
    private UserEntityRepository userEntityRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(RoleEntityRepository roleEntityRepository, UserEntityRepository userEntityRepository, PasswordEncoder passwordEncoder) {
        this.roleEntityRepository = roleEntityRepository;
        this.userEntityRepository = userEntityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity saveUser(UserEntity userEntity) {
        RoleEntity roleEntity = roleEntityRepository.findByName("ROLE_USER");
        userEntity.setRoleEntity(roleEntity);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userEntityRepository.save(userEntity);
    }

    public UserEntity findByLogin(String login) {
        return userEntityRepository.findByLogin(login);
    }

    public UserEntity findByLoginAndPassword(String login, String password) {
        UserEntity userEntity = findByLogin(login);

        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())){
                return userEntity;
            }
        }

        return null;
    }
}
