package com.aka.prototicket.dao;

import com.aka.prototicket.entity.User;



public interface UserDAO {
	
	public User getUser(String login);

}
