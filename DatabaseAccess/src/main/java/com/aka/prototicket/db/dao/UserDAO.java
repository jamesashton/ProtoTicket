package com.aka.prototicket.db.dao;

import com.aka.prototicket.db.entity.User;



public interface UserDAO {
	
	public User getUser(String login);

}
