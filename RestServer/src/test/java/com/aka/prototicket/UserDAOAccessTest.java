package com.aka.prototicket;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aka.prototicket.dao.UserDAO;
import com.aka.prototicket.entity.User;

@Transactional
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOAccessTest
{
	
	@Autowired
	private UserDAO userDAO;

	@Test
	public void testGetUser()
	{
		User user = userDAO.getUser("admin");
		if(user == null)
		{
			fail("Unable to find user.");
		}
		else
		{
			assertEquals( "admin", user.getLogin() );
			assertEquals( "admin123", user.getPassword() );
			assertEquals( "admin@nowhere.xom", user.getEmail() );
			assertEquals( "admin", user.getFirstname() );
			assertEquals( "istrator", user.getLastname() );
		}
		
	}

}
