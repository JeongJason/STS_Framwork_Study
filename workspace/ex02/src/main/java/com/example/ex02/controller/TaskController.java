package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
	// ID와 PW을 입력받은후 아이디가 admin일 경ㅇ admin.jsp로 이동
	// 아이디가 user일 경우 user.html로 이동
	
	// - admin.jsp
	
	// - user.jsp
	
	@GetMapping("loginForm")
	public String goLoginForm() {
		return "task/task01/login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("id")String id, String pw) {
		if(id.equals("admin")) {
			return "task/task01/admin";
		}
		return "task/task01/user";
	}
}
