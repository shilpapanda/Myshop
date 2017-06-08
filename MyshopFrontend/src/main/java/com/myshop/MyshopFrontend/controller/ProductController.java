package com.myshop.MyshopFrontend.controller;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myshop.MyshopBackend.model.*;
import com.myshop.MyshopBackend.dao.*;

@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="Product")
	public String showProduct(Model m)
	{
		Product product = new Product();
		m.addAttribute(product);
		
		List<Product> list=productDAO.retrieveProduct();
		m.addAttribute("proddet",list);
		
		m.addAttribute("catlist",this.getCategories());
		return "Product";
	}
	
	@RequestMapping(value="InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") Product product,@RequestParam("pimage") MultipartFile filedet,Model m)
	{
		productDAO.insertProduct(product);
		
		// Image Uploading Code
		String path = "D:\\myshop\\MyshopFrontend\\src\\main\\webapp\\resources\\images\\";
		
		path = path + String.valueOf(product.getProdid()) + ".jpg";
		
		File f=new File(path);
		
		if (!filedet.isEmpty()) 
		{
			try
			{
				byte[] bytes = filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(f);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(bytes);
				bs.close();
				
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
			}
			
		}
		else
		{
			System.out.println("File Uploading Problem");
		}
		
		//Complete Image Uploading
		
		Product product1 = new Product();
		m.addAttribute(product1);
		
		List<Product> list=productDAO.retrieveProduct();
		m.addAttribute("proddet",list);
		
		return "Product";
	}
	
	@RequestMapping(value="deleteProduct/{prodid}",method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("prodid")int prodid,Model m)
	{
		
		productDAO.deleteProduct(prodid);
		
		Product product1 = new Product();
		m.addAttribute(product1);
		
		List<Product> list=productDAO.retrieveProduct();
		m.addAttribute("proddet",list);
		
		return "Product";
	}
	
	@RequestMapping(value="updateProduct/{prodid}",method=RequestMethod.GET)
	public String readyUpdate(@PathVariable("prodid")int prodid,Model m)
	{
		Product product=productDAO.getProduct(prodid);
		m.addAttribute(product);
		
		List<Product> list=productDAO.retrieveProduct();
		m.addAttribute("proddet",list);
		
		return "UpdateProduct";
	}
	
	@RequestMapping(value="UpdateProduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product product,Model m)
	{
		productDAO.updateProduct(product);
		
		Product product1 = new Product();
		m.addAttribute(product1);
		
		List<Product> list=productDAO.retrieveProduct();
		m.addAttribute("proddet",list);
		
		return "redirect:/Product";
	}
	
	public LinkedHashMap<Integer,String> getCategories()
	{
		List<Category> list=categoryDAO.retrieve();
		
		LinkedHashMap<Integer,String> catlist=new LinkedHashMap<Integer,String>();
		
		for(Category cat:list)
		{
			catlist.put(cat.getCatid(),cat.getCatname());
		}
		
		return catlist;
	}
}
