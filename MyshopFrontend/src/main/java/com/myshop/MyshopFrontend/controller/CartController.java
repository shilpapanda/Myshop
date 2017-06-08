package com.myshop.MyshopFrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myshop.MyshopBackend.dao.*;
import com.myshop.MyshopBackend.model.*;

@Controller
public class CartController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="ShowCart")
	public String showCartPage(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<Cart> cartitems=cartDAO.getCartItems(username);
		m.addAttribute("cartitems",cartitems);
		return "Cart";
	}
	
	@RequestMapping(value="/addToCart/{prodid}")
	public String addToCart(@PathVariable("prodid")int prodid,@RequestParam("quantity") int qty,HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		Cart mycart=new Cart();
		
		Product product=productDAO.getProduct(prodid);
		int price=product.getPrice();
		
		mycart.setProdid(prodid);
		mycart.setQuantity(qty);
		mycart.setStatus("NP");
		mycart.setUsername(username);
		mycart.setCartid("C1001");
		mycart.setSubtotal(qty*price);
		
		cartDAO.addtoCart(mycart);
		
		List<Cart> cartitems=cartDAO.getCartItems(username);
		m.addAttribute("cartitems",cartitems);
		
		return "Cart";
	}
	
	@RequestMapping(value="deleteCartItem/{cid}")
	public String deleteCartItem(@PathVariable("cid") int cid,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		cartDAO.deleteCartItem(cid);
		
		List<Cart> cartitems=cartDAO.getCartItems(username);
		m.addAttribute("cartitems",cartitems);
		return "Cart";
	}
	
	@RequestMapping(value="updateCartItem/{cid}")
	public String updateCartItem(@PathVariable("cid")int cid,@RequestParam("qty")int qty,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		Cart cartitem=cartDAO.getCartItem(cid);
		
		Product product=productDAO.getProduct(cartitem.getProdid());
		int price=product.getPrice();
		
		cartitem.setQuantity(qty);
		cartitem.setSubtotal(qty*price);
		
		cartDAO.updateCart(cartitem);
		
		List<Cart> cartitems=cartDAO.getCartItems(username);
		m.addAttribute("cartitems",cartitems);
		
		return "Cart";
		
	}
	
}
