package com.nnh.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nnh.dto.DeleteUserDTO;
import com.nnh.dto.UserDTO;
import com.nnh.model.user.UserEntity;
import com.nnh.repository.user.UserRepository;
import com.nnh.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepo;

	public List<UserDTO> getAll() {
		return userRepo.findAllByDefaultQuery();
	}

	@Override
	public UserDTO getByDefaultQuery(UserDTO dto) {
		return userRepo.findOneByDefaultQuery(dto.getEmail());
	}

	@Override
	public UserDTO getByTypedQuery(UserDTO dto) {
		return userRepo.findOneByTypedQuery(dto.getEmail());
	}

	@Override
	public UserDTO getByNamedQuery(UserDTO dto) {
		return userRepo.findOneByNamedQuery(dto.getEmail());
	}

	@Override
	public Page<UserDTO> getPagination(Pageable pageable) {
		List<UserDTO> dtoList = userRepo.findAll(pageable).getContent().stream().map(item -> {
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(item, dto);
			
	        return dto;
		}).collect(Collectors.toList());
		
		return new PageImpl<>(dtoList);
	}

	@Override
	@Transactional
	public void createByDefaultQuery(UserDTO dto) {
		UserEntity entity = new UserEntity();
		
		BeanUtils.copyProperties(dto, entity);
		
		userRepo.createByDefaultQuery(entity);
	}

	@Override
	@Transactional
	public void updateByTypedQuery(UserDTO dto) {
		UserEntity entity = new UserEntity();
		
		BeanUtils.copyProperties(dto, entity);
		
		userRepo.updateByTypedQuery(entity);
	}

	@Override
	@Transactional
	public void deleteByNamedQuery(DeleteUserDTO dto) {
		UserEntity entity = new UserEntity();
		
		entity.setId(dto.getId());
		
		userRepo.deleteByNamedQuery(entity);
	}
}
