package com.ph.sinonet.spring.dao;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ph.sinonet.spring.model.entity.User;

@Repository
@Transactional
public class UserDao {

	private GenericDao<User> userDao;

	@Autowired
	public void setUserDao(GenericDao<User> userDao) {
		this.userDao = userDao;
		userDao.setClazz(User.class);
	}


	public User getUserByName(String name){
		return userDao.findById(name);
	}

	
	public void saveUser(User user){
		userDao.save(user);
	}

	public void updateUser(User user){
		userDao.update(user);
	}
	
	
	public User getUserAuth(String name){
		Criteria criteria = userDao.getCurrentSession().createCriteria(User.class);
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("username"))
				.add(Projections.property("password")));
		criteria.add(Restrictions.eq("usernmae", name));
		criteria.setResultTransformer(Transformers.aliasToBean(User.class));
		return (User) criteria.uniqueResult();
	}
	
	public User findUserWithLockMode(String name, LockMode lock){
		return userDao.findById(name, lock);
	}
	
}


