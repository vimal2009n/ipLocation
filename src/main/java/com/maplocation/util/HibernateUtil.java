package com.maplocation.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUtil {

	@Autowired
	private SessionFactory sessionFactory;
	
	 @SuppressWarnings("rawtypes")
		public <T> List fetchAll(String query) {  
		 
	        return sessionFactory.getCurrentSession().createSQLQuery(query).list();        
	    }
	 
	 @SuppressWarnings("unchecked")
		public <T> T fetchById(Serializable id, Class<T> entityClass) {
	        return (T)sessionFactory.getCurrentSession().get(entityClass, id);
	    }
}