package com.aka.prototicket.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aka.prototicket.db.dao.UserDAO;
import com.aka.prototicket.db.entity.User;


@Service
@Transactional
public class UserServiceImpl implements UserService 
{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUser(String login) {
		return userDAO.getUser(login);
	}

}
