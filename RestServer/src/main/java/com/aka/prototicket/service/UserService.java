package com.aka.prototicket.service;

import com.aka.prototicket.db.entity.User;


public interface UserService {
	
	public User getUser(String login);

}
