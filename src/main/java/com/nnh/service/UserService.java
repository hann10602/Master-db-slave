package com.nnh.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nnh.dto.DeleteUserDTO;
import com.nnh.dto.UserDTO;


public interface UserService {
	List<UserDTO> getAll();
	Page<UserDTO> getPagination(Pageable pageable);
	
	UserDTO getByDefaultQuery(UserDTO dto);
	UserDTO getByTypedQuery(UserDTO dto);
	UserDTO getByNamedQuery(UserDTO dto);

	void createByDefaultQuery(UserDTO dto);
	void updateByTypedQuery(UserDTO dto);
	void deleteByNamedQuery(DeleteUserDTO dto);
}
