package com.maplocation.util;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUtil {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*@SuppressWarnings("unchecked")
		public <T> T fetchByName(Serializable name, Class<T> entityClass) {
		   return (T) sessionFactory.getCurrentSession().get(entityClass, name);
	    }*/

	 @SuppressWarnings("rawtypes")
		public <T> List fetchAll(String query) {  
		 
	        return sessionFactory.getCurrentSession().createSQLQuery(query).list();        
	    }
	 

}
