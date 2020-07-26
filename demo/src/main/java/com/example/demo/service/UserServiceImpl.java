package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundExeption;
import com.example.demo.mapper.UserMapper;

@Component
public class UserServiceImpl implements UserService{
	@Autowired
	private static ArrayList<User> listUser = new ArrayList<User>();
	
	static {
		
		listUser.add(new User(1, "Nguyen A", "a@gmail.com", "098", "hihi.png", "Aa123456"));
		listUser.add(new User(2, "Nguyen B", "a@gmail.com", "098", "hihi.png", "Aa123456"));
		listUser.add(new User(3, "Nguyen AA", "a@gmail.com", "098", "hihi.png", "Aa123456"));
		listUser.add(new User(4, "Nguyen AB", "a@gmail.com", "098", "hihi.png", "Aa123456"));
	}

	@Override
	public List<UserDto> getListUser() {
		List<UserDto> result = new ArrayList<UserDto>();
		for(User user : listUser) {
			result.add(UserMapper.toUserDto(user));
		}
		return result;
	}

	@Override
	public UserDto getUserById(int id) {
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
		List<UserDto> result = new ArrayList<UserDto>();
		for(User user : listUser) {
			if(user.getName().contains(keyword)) {
				result.add(UserMapper.toUserDto(user));
			}
		}
		return result;
	}

}
