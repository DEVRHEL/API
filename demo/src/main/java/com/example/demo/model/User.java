package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User{
	//private static final long serialVersionUID = -297553281792804396L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "avatar")
	private String avatar;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "code")
	private Enumcode code;
	
	public User() {
		
	}

	public User(Long id, String name, String email, String phone, String avatar, String password, Enumcode code) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.avatar = avatar;
		this.password = password;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Enumcode getCode() {
		return code;
	}

	public void setCode(Enumcode code) {
		this.code = code;
	}
}
