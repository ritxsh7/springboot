package com.infosys.spring_mvc_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infosys.spring_mvc_db.entity.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update user_details set password = ? where userid = ?", nativeQuery = true)
	public void updatePassword(String password, Integer userid);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="delete from user_details where userid = ?", nativeQuery = true)
	public void deleteUser(Integer userid);
}
