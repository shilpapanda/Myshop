package com.myshop.MyshopFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myshop.MyshopBackend.dao.CategoryDAO;
import com.myshop.MyshopBackend.model.*;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="CategoryAddition",method=RequestMethod.GET)
	public String addCategory(@RequestParam("catid") int catid,@RequestParam("catname") String catname,@RequestParam("catdesc") String catdesc,Model m)
	{	
		Category category=new Category();
		category.setCatid(catid);
		category.setCatname(catname);
		category.setCatdesc(catdesc);
		
		categoryDAO.insertCategory(category);
		
		List<Category> list=categoryDAO.retrieve();
		m.addAttribute("catlist",list);
		
		return "Category";
	}
	
	@RequestMapping("Category")
	public String showCategoryPage(Model m)
	{
		List<Category> list=categoryDAO.retrieve();
		m.addAttribute("catlist",list);		
		return "Category";
	}
	
	@RequestMapping(value="deleteCategory/{catid}",method=RequestMethod.GET)
	public String deleteCategory(@PathVariable("catid")int catid,Model m)
	{
		categoryDAO.deleteCategory(catid);
		List<Category> list=categoryDAO.retrieve();
		m.addAttribute("catlist",list);
		return "Category";
	}
}
