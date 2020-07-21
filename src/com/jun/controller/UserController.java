package com.jun.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jun.dao.UserDao;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "t1",produces="application/json;charset=utf-8")
	@ResponseBody
	public String t1(@RequestParam(name = "name") String name) {
		System.out.println(name);
		return "中文";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	//登录
	@RequestMapping(value = "loginOpe",method = RequestMethod.POST)
	public String login(HttpSession session, @RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		session.setAttribute("username", username);
		int flag = userDao.Login(username, password);
		if(flag>0) {
			return "redirect:/findAll";
		}
		return "login";
	}
	
	//注册
	@RequestMapping(value = "register",method = RequestMethod.POST)
	public String register(String username,String password) {
		int flag = userDao.Regist(username, password);
		if(flag>0) {
			return "login";
		}
		return "register";
	}
	
	//退出登录
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
