package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserController {
	@Autowired
	private UserService user;
	
	@GetMapping(value = "")
	public ResponseEntity<?> getListUser()
	{
		List<UserDto> listUser = user.getListUser();
		return ResponseEntity.ok(listUser);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id){
		UserDto result = user.getUserById(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<?> searchUser(@RequestParam(name = "keyword", required = false, defaultValue = "")String name){
		List<UserDto> result = user.searchUser(name);
		return ResponseEntity.ok(result);
	}
}
