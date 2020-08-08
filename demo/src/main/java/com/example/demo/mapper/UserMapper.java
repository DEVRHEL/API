package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

public class UserMapper {
	public static UserDto toUserDto(User user) {
		UserDto tmp = new UserDto();
		tmp.setId(user.getId());
		tmp.setName(user.getName());
		tmp.setEmail(user.getEmail());
		tmp.setPhone(user.getPhone());
		tmp.setAvatar(user.getAvatar());
		tmp.setCode(user.getCode().getCode());
		
		return tmp;
	}
}
