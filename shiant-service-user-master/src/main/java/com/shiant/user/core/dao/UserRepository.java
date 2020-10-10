package com.shiant.user.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.shiant.user.core.model.User;


@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User>{

	List<User> findByUseridIn(List<Long> userid);

	User findByUserName(String userName);

	List<User> findByOrgOrgidAndListOfRoleRoleidIn(Long orgid, List<Long> roleids);
	
}
