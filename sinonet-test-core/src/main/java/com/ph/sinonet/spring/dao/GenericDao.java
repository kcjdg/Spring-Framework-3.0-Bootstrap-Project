package com.ph.sinonet.spring.dao;



import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericDao<T> extends AbstractHibernateDao<T> {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@PostConstruct
	public void init(){
		setSessionFactory(sessionFactory);
	}
	
	public GenericDao() {}

	
}
