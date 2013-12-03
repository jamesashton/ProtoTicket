package com.aka.prototicket.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.aka.prototicket.entity.User;


@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public User getUser(String login) {
		
		Query query = openSession().createQuery("select user from User user join user.role role where user.login = :login  ");
		
		query.setParameter("login", login);
		
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>)(List<?>)Arrays.asList( query.list().toArray());
		User out = null;
				
		if (userList.size() > 0)
			out = userList.get(0);
	
		return out;
	}

}
