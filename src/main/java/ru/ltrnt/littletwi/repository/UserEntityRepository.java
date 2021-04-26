package ru.ltrnt.littletwi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ltrnt.littletwi.entity.UserEntity;


public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByLogin(String login);
}
