package com.nnh.repository.user;

import java.util.List;

import com.nnh.dto.UserDTO;
import com.nnh.model.user.UserEntity;

public interface UserRepoCustom {
	List<UserDTO> findAllByDefaultQuery();
	
	UserDTO findOneByDefaultQuery(String email);
	UserDTO findOneByTypedQuery(String email);
	UserDTO findOneByNamedQuery(String email);
	
	void createByDefaultQuery(UserEntity entity);
	void updateByTypedQuery(UserEntity entity);
	void deleteByNamedQuery(UserEntity entity);
}
