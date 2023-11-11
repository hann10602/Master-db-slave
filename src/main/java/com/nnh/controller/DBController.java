package com.nnh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nnh.dto.DeleteUserDTO;
import com.nnh.dto.UserDTO;
import com.nnh.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class DBController {
	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserDTO> search() {
		return userService.getAll();
	}
	
	@GetMapping("/default-query")
	public UserDTO defaultQuery(@RequestBody UserDTO dto) {
		return userService.getByDefaultQuery(dto);
	}
	
	@GetMapping("/typed-query")
	public UserDTO typedQuery(@RequestBody UserDTO dto) {
		return userService.getByTypedQuery(dto);
	}
	
	@GetMapping("/named-query")
	public UserDTO namedQuery(@RequestBody UserDTO dto) {
		return userService.getByNamedQuery(dto);
	}

	@GetMapping("/page")
	public Page<UserDTO> getPagination() {
		Pageable pageable = PageRequest.of(1, 2, Sort.by("username").ascending());
		
		return userService.getPagination(pageable);
	}
	
	@PostMapping("/create")
	public void createByDefaultQuery(@RequestBody UserDTO dto) {
		userService.createByDefaultQuery(dto);
	}
	
	@PostMapping("/update")
	public void updateByTypedQuery(@RequestBody UserDTO dto) {
		userService.updateByTypedQuery(dto);
	}
	
	@PostMapping("/delete")
	public void deleteByNamedQuery(@RequestBody DeleteUserDTO dto) {
		userService.deleteByNamedQuery(dto);
	}
}
