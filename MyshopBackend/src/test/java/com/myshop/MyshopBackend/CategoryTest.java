package com.myshop.MyshopBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myshop.MyshopBackend.dao.CategoryDAO;
import com.myshop.MyshopBackend.model.Category;

public class CategoryTest 
{
	@SuppressWarnings("resource")
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.myshop.MyshopBackend");
		context.refresh();
		
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
		List<Category> list=categoryDAO.retrieve();
		
		for(Category category:list)
		{
			System.out.print(category.getCatid());
			System.out.print(category.getCatname());
			System.out.println(category.getCatdesc());
		}
		
	}
}
