package com.shiant.user.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.shiant.user.core.model.Role;

@Repository(value = "roleRepository")
public interface RoleRepository  extends JpaRepository<Role, Long>,JpaSpecificationExecutor<Role>{
	
}
