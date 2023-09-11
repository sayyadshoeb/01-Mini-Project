package com.shoebit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shoebit.entities.UserAccount;

import jakarta.transaction.Transactional;


public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {
	@Modifying
	@Transactional
	@Query("update UserAccount set activesw=:status where userid=:userid")
	public void updateUserAccStatus(Integer userid,String status);
}
