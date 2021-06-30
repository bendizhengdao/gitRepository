package com.ssm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ssm.pojo.Roles;
import com.ssm.pojo.Users;

public interface RoleRepository extends JpaRepository<Roles, Integer>,JpaSpecificationExecutor<Users> {

}
