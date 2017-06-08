package com.myshop.MyshopBackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.MyshopBackend.model.Cart;

@SuppressWarnings("deprecation")
@Repository("cartDAO")
public class CartDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void addtoCart(Cart cart)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}
	
	@Transactional
	public void deleteCartItem(int cid)
	{
		Cart myCartItem=(Cart)sessionFactory.getCurrentSession().get(Cart.class,cid);
		sessionFactory.getCurrentSession().delete(myCartItem);
	}
	@Transactional
	public Cart getCartItem(int cid)
	{
		Session session=sessionFactory.getCurrentSession();
		Cart mycartitem=(Cart)session.get(Cart.class,cid);
		//session.close();
		return mycartitem;
		
	}
	
	@Transactional
	public void updateCart(Cart cart)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}
	@SuppressWarnings("rawtypes")
	@Transactional
	public List<Cart> getCartItems(String username)
	{
		Query q=sessionFactory.openSession().createQuery("from Cart where status='NP' and username=:uname");
		q.setParameter("uname",username);
		@SuppressWarnings("unchecked")
		List<Cart> list=q.list();
		return list;
	}
}
