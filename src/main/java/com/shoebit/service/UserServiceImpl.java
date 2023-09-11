package com.shoebit.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoebit.entities.UserAccount;
import com.shoebit.repo.UserAccountRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private	UserAccountRepo userAccountRepo;
	
	
	@Override
	public String saveUserAcc(UserAccount userAccount) {
		Integer userid=userAccount.getUserid();
		
		userAccountRepo.save(userAccount);
		
		if(userid==null) {
			return "Record saved";
		}
		else {
			return "Record Updated";
		}
		
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		List<UserAccount> account= userAccountRepo.findAll();
		return account;
	}

	@Override
	public UserAccount getUserAcc(Integer userid) {
			Optional<UserAccount> findById = userAccountRepo.findById(userid);
			if(findById.isPresent()) {
				return findById.get();
			}
		return null;
	}

	@Override
	public boolean deleteUserAcc(Integer userid) {
		try {
			userAccountRepo.deleteById(userid);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	
	@Override
	public boolean updateUserAccStatus(Integer userid, String status) {
		try {
			userAccountRepo.updateUserAccStatus(userid, status);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
