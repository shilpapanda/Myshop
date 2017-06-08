package com.myshop.MyshopBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myshop.MyshopBackend.dao.UserDAO;
import com.myshop.MyshopBackend.model.User;

public class UserTest 
{
	@SuppressWarnings("resource")
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.myshop.MyshopBackend");
		context.refresh();
		
		UserDAO userDAO=(UserDAO)context.getBean("userDAO");
		
		List<User> list=userDAO.retrieve();
		
		for(User user:list)
		{
			System.out.print(user.getUsername());
			System.out.print(user.getPassword());
			System.out.println(user.getCustname());
			System.out.println(user.getRoleuser());
			System.out.println(user.getRoleadmin());
			System.out.println(user.getEmail());
			System.out.println(user.getMobileno());
			System.out.println(user.getAddr());
		}
		
	}
}
