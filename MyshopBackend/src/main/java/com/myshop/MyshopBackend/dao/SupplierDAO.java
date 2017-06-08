package com.myshop.MyshopBackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.MyshopBackend.model.Supplier;

import com.myshop.MyshopBackend.model.*;

@SuppressWarnings("unused")
@Repository("supplierDAO")
public class SupplierDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertSupplier(Supplier supplier)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(supplier);
	}
	
	@Transactional 
	public void deleteSupplier(int suppid)
	{
		Session session=sessionFactory.getCurrentSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,suppid);
		session.delete(supplier);
	}
	
	@SuppressWarnings("deprecation")
	public List<Supplier> retrieve()
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Supplier> list=session.createQuery("from Supplier").list();
		session.close();
		return list;
	}
	
	
	
	
}
