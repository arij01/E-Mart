package com.esprit.rahma.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.esprit.rahma.model.User;
import com.esprit.rahma.repository.UserRepository;

@Service
public class UserDetailServiceImp  {

	@Autowired
	UserRepository userRepository;
	



}
