package com.cognizant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.Exception.userNotFoundException;
import com.cognizant.entity.User;
import com.cognizant.repo.userRepo;
import com.cognizant.response.CommonResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private userRepo repo;
	
	@Autowired
	private  BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User createUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return this.repo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		List<User> findAll = this.repo.findAll();
		if (findAll.isEmpty()) {
			throw new userNotFoundException("No Data Found ! ");
		}
		return findAll;
	}

	@Override
	public User getUserById(int id) {
		return this.repo.findById(id)
				.orElseThrow(() -> new userNotFoundException("User Not Found With UserId : " + id));
	}

	@Override
	public User updateUserById(int id, User user) {
		User OldUser = this.repo.findById(id)
				.orElseThrow(() -> new userNotFoundException("User Not Found With UserId : " + id));
		OldUser.setEmail(user.getEmail());
		OldUser.setPassword(user.getPassword());
		OldUser.setRole(user.getRole());
		return this.repo.save(OldUser);
	}

	@Override
	public CommonResponse deleteUser(int id) {
		User user1 = this.repo.findById(id)
				.orElseThrow(() -> new userNotFoundException("User Not Found With UserId : " + id));
		CommonResponse cr = new CommonResponse();
		cr.setMessage("User Deleted With Id" + id);
		cr.setUser(user1);
		this.repo.deleteById(id);
		return cr;

	}

}
