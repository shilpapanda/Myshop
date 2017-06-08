package com.myshop.MyshopBackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.MyshopBackend.model.OrderDetail;

import com.myshop.MyshopBackend.model.*;

@SuppressWarnings("unused")
@Repository("orderdetailDAO")
public class OrderDetailDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderDetailDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertOrderDetail(OrderDetail orderdetail)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(orderdetail);
	}
	
	@Transactional 
	public void deleteOrderDetail(int orderid)
	{
		Session session=sessionFactory.getCurrentSession();
		OrderDetail orderdetail=(OrderDetail)session.get(OrderDetail.class,orderid);
		session.delete(orderdetail);
	}
	
	@SuppressWarnings("deprecation")
	public List<OrderDetail> retrieveOrders(String username)
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<OrderDetail> list=session.createQuery("from OrderDetail").list();
		session.close();
		return list;
	}
	
	
	
	
}
