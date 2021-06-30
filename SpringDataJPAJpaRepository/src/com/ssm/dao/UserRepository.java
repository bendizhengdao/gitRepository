package com.ssm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ssm.pojo.Users;

public interface UserRepository extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users> {

}
