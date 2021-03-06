package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.exception.NotFoundExeption;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<UserDto> getListUser() {
		List<UserDto> result = new ArrayList<UserDto>();
		
		for(User user : (ArrayList<User>) userRepository.findAll()) {
			result.add(UserMapper.toUserDto(user));
		}
		
		return result;
	}

	@Override
	public UserDto getUserById(Long id) {
		for(User user : (ArrayList<User>) userRepository.findAll()) {
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
		
		for(User user : (ArrayList<User>) userRepository.findAll()) {
			if(user.getName().contains(keyword)) {
				result.add(UserMapper.toUserDto(user));
			}
		}
		
		return result;
	}

	@Override
	public int removeUser(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			return 1;
		}
		
		throw new NotFoundExeption("User Not Found");
	}

	@Override
	public int saveUser(User user) {
		if(user.getId() == null) throw new NotFoundExeption("ID user is null");
		if(user.getName() == null) throw new NotFoundExeption("Name user is null");
		if(user.getPassword() == null) throw new NotFoundExeption("Password user is null");
		if (userRepository.findById(user.getId()).isPresent()) throw new NotFoundExeption("Duplicate user");
		userRepository.save(user);
		return 1;
	}

	@Override
	public int updateUser(Long id, User user) {
		Optional<User> currentUser = userRepository.findById(id);
		if(!currentUser.isPresent()) throw new NotFoundExeption("User Not Found");
		currentUser.get().setName(user.getName());
		currentUser.get().setEmail(user.getEmail());
		currentUser.get().setAvatar(user.getAvatar());
		currentUser.get().setPhone(user.getPhone());
		currentUser.get().setPassword(user.getPassword());
		userRepository.save(currentUser.get());
		return 1;
	}

}
