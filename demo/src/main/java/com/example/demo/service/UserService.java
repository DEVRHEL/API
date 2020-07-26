package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

@Service
public interface UserService {
	public List<UserDto> getListUser();
	
	public UserDto getUserById(Long id);
	
	public List<UserDto> searchUser(String keyword);
	
	public int removeUser(Long id);
	
	public int saveUser(User userEntity);

	public int updateUser(Long id, User user);
}
