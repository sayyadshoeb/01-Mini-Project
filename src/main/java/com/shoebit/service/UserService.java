package com.shoebit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoebit.entities.UserAccount;

@Service
public interface UserService {
	public String saveUserAcc(UserAccount userAccount);
	
	public List<UserAccount> getAllUserAccounts();
	
	public UserAccount getUserAcc(Integer userid);
	
	public boolean deleteUserAcc(Integer userid);
	
	public boolean updateUserAccStatus(Integer userid,String status); 
	
		
	
}
