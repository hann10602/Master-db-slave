package com.nnh.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nnh.model.user.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, PagingAndSortingRepository<UserEntity, Long>, UserRepoCustom{
	@Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
	UserEntity findOne(@Param("email") String email);
}

