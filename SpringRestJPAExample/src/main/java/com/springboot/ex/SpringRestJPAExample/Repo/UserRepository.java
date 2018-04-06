package com.springboot.ex.SpringRestJPAExample.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ex.SpringRestJPAExample.Model.User;
/**
 * User Repository Class
 * 
 * @author Udhay
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAll();	
	
	User findByUserID(long userID);
	
	long deleteByUserID(long userID);

	void deleteAll();
}
