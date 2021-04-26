package ru.ltrnt.littletwi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ltrnt.littletwi.entity.RoleEntity;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);
}
