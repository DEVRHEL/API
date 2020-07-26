package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Component
public class UserRepositoryServiceImpl implements UserRepositoryService{

	@Autowired
    private UserRepository repository;
	
	@Override
	public ArrayList<User> findAll() {
		 return (ArrayList<User>) repository.findAll();
	}

}