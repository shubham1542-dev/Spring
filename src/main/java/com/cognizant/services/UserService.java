package com.cognizant.services;

import java.util.List;

import com.cognizant.entity.User;
import com.cognizant.response.CommonResponse;

public interface UserService {
	
	User createUser(User user);
	
	List<User> getAllUser();
	
	User getUserById(int id);
	
	User updateUserById(int id, User user);
	
	CommonResponse deleteUser(int id);

}
