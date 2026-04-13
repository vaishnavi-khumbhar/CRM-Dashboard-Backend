package com.crm.project.repository;

import com.crm.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSettingRepository extends JpaRepository<User, Long> {
}