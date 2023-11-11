package com.nnh.repository.user.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;

import com.nnh.dto.UserDTO;
import com.nnh.model.user.UserEntity;
import com.nnh.repository.user.UserRepoCustom;

public class UserRepoCustomImpl implements UserRepoCustom{
	private final EntityManager em;
	private final EntityManager em1;
	
	public UserRepoCustomImpl(EntityManager em, EntityManager em1) {
		super();
		this.em = em;
		this.em1 = em1;
	}
	
	@Override
	public List<UserDTO> findAllByDefaultQuery() {
		List<UserDTO> dtoList = new ArrayList<>();
		
		String jpql = "SELECT u FROM UserEntity u";
		
		Query query = em.createQuery(jpql);
		
		List<UserEntity> entityList = query.getResultList();
		
		entityList.forEach(item -> {
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(item, dto);
			dtoList.add(dto);
		});
		
		return dtoList;
	}

	@Override
	public UserDTO findOneByTypedQuery(String email) {
		UserDTO dto = new UserDTO();
		
		TypedQuery<UserEntity> query = em.createQuery("SELECT u FROM UserEntity u WHERE u.email = :email", UserEntity.class);
		
		query.setParameter("email", email);
		
		UserEntity entity = (UserEntity) query.getSingleResult();
		
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	@Override
	public UserDTO findOneByDefaultQuery(String email) {
		UserDTO dto = new UserDTO();
		
		String jpql = "SELECT u FROM UserEntity u WHERE u.email = :email";
		
		Query query = em.createQuery(jpql);
		
		query.setParameter("email", email);
		
		UserEntity entity = (UserEntity) query.getSingleResult();
		
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public UserDTO findOneByNamedQuery(String email) {

		UserDTO dto = new UserDTO();
		
		Query query = em.createNamedQuery("User/findByNamedQuery");
		
		query.setParameter("email", email);
		
		UserEntity entity = (UserEntity) query.getSingleResult();
		
		BeanUtils.copyProperties(entity, dto);
		
		return dto;
	}

	@Override
	public void createByDefaultQuery(UserEntity entity) {
		em1.persist(entity);
	}

	@Override
	public void updateByTypedQuery(UserEntity entity) {
		em.merge(entity);
	}

	@Override
	public void deleteByNamedQuery(UserEntity entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}
	
}

