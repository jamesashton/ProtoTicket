package com.aka.prototicket.model;

import java.io.Serializable;

import com.aka.prototicket.entity.User;

public class LoginStatus implements Serializable {

	private static final long serialVersionUID = 440097928309592760L;
	private final boolean success;
	private final boolean loggedIn;
    private final String username;
    private final String errorMessage;
    private final User user;
    public LoginStatus(boolean success, boolean loggedIn, String username, String errorMessage, User user) {
    	this.success = success;
        this.loggedIn = loggedIn;
        this.username = username;
    	this.errorMessage = errorMessage;
    	this.user = user;
    }

    public String getErrorMessage() {
		return errorMessage;
	}

	public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUsername() {
        return username;
    }

    public boolean isSuccess() {
		return success;
	}
    
    public User getUser()
    {
    	return user;
    }
}
