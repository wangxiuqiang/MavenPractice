package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.service.UserService;

public class tests {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		UserService userService = (UserService) context.getBean("userService");
		userService.acountMoney();
	}

}
