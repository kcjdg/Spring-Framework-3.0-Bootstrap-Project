package com.ph.sinonet.spring.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractHibernateDao<T >{

	private Class <T> clazz;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected void setClazz(Class <T> clazzToSet){
		this.clazz = clazzToSet;
	}
	
	public void save(T entity){
		 getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(T entity){
		getCurrentSession().saveOrUpdate(entity);
	}
	
	public void persist(T entity){
		getCurrentSession().persist(entity);
	}
	
	public void merge(T entity){
		getCurrentSession().merge(entity);
	}
	
	public void update(T entity){
		getCurrentSession().update(entity);
	}
	
	public void delete(T entity){
		getCurrentSession().delete(entity);
	}
	
	
	public T findById(Object id){
		return (T) getCurrentSession().get(clazz, (Serializable) id);
	}
	
	public T findById(Object id, LockMode mode){
		return (T) getCurrentSession().get(clazz, (Serializable) id, mode);
	}
	
	public T findById(Object id, LockOptions options){
		return (T) getCurrentSession().get(clazz, (Serializable)id, options);
	}
	
	public void deleteById(Object id){
		T entity = findById(id);
		delete(entity);
	}
	
	public List<T> findAll(){
		return createCriteria().list();
	}
	
	public List<T> findByCriteria(DetachedCriteria criteria){
		return findByCriteria(criteria,-1,-1);
	}
	
	public List<T> findByCriteria(DetachedCriteria criteria,final int firstResult, final int maxResult){
		return createCriteria().setFirstResult(firstResult).setMaxResults(maxResult).list();
	}
	
	
	protected final Criteria createCriteria(){
		return getCurrentSession().createCriteria(clazz);
	}
	
	protected final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
}
