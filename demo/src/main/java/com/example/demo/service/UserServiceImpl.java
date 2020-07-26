package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.exception.NotFoundExeption;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepositoryService userRepository;
	
	private ArrayList<User> listUser = new ArrayList<User>();
	
	@Override
	public List<UserDto> getListUser() {
		listUser = (ArrayList<User>) userRepository.findAll();
		List<UserDto> result = new ArrayList<UserDto>();
		
		for(User user : listUser) {
			result.add(UserMapper.toUserDto(user));
		}
		
		return result;
	}

	@Override
	public UserDto getUserById(int id) {
		listUser = (ArrayList<User>) userRepository.findAll();
		
		for(User user : listUser) {
			if(user.getId() == id)
			{
				return UserMapper.toUserDto(user);
			}
		}
		
		throw new NotFoundExeption("User Not Found");
	}

	@Override
	public List<UserDto> searchUser(String keyword) {
		listUser = (ArrayList<User>) userRepository.findAll();
		List<UserDto> result = new ArrayList<UserDto>();
		
		for(User user : listUser) {
			if(user.getName().contains(keyword)) {
				result.add(UserMapper.toUserDto(user));
			}
		}
		
		return result;
	}

}
