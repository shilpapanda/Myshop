package com.myshop.MyshopBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myshop.MyshopBackend.dao.CartDAO;
import com.myshop.MyshopBackend.model.*;

@SuppressWarnings("unused")
public class CartTest 
{
	@SuppressWarnings("resource")
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.myshop.MyshopBackend");
		context.refresh();
		
		CartDAO cartDAO=(CartDAO)context.getBean("cartDAO");
		
		//Add to Cart
		Cart mycart=new Cart();
		
		mycart.setCartid("C1001");
		mycart.setProdid(1012);
		mycart.setQuantity(3);
		mycart.setStatus("NP");
		mycart.setSubtotal(9000);
		mycart.setUsername("sunita");
		
		cartDAO.addtoCart(mycart);
		System.out.println("Cart Item Added");
		
		//====================================
		//Deleting the Cart Item
		
		//cartDAO.deleteCartItem(17);
		//System.out.println("Cart Deleted");
		
		//=======================================
		//Retrieving the cart Items
		
		/*List<Cart> cartitems=cartDAO.getCartItems("kiran");
		
		for(Cart c:cartitems)
		{
			System.out.println(c.getCartid()+":"+c.getProdid()+":"+c.getQuantity()+":"+c.getUsername());
		}*/
		
		//=============================================
		//Update the Cart Item
		
		/*Cart mycartitem=cartDAO.getCartItem(19);
		mycartitem.setQuantity(5);
		mycartitem.setSubtotal(12500);
		cartDAO.updateCart(mycartitem);
		
		System.out.println("CartItem is updated");  */
		
	}

}
