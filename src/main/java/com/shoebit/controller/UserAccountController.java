package com.shoebit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shoebit.entities.UserAccount;
import com.shoebit.service.UserService;

@Controller
public class UserAccountController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new UserAccount());
		return "index";
	}
	
	@PostMapping("/save")
	public String handleSubmitBtn(@ModelAttribute("user") UserAccount user,Model model) {
		System.out.println(user);
		String msg = service.saveUserAcc(user);
		model.addAttribute("msg",msg);
		return "index";
	}
	@GetMapping("/users")
	public String getusers(Model model) {
		List<UserAccount>userlist=service.getAllUserAccounts();
		model.addAttribute("users",userlist);
		return "view-users";
		
	}

}
