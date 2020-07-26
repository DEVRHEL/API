package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

@Service
public interface UserService {
	public List<UserDto> getListUser();
	
	public UserDto getUserById(int id);
	
	public List<UserDto> searchUser(String keyword);
}
