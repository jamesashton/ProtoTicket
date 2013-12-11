package com.aka.prototicket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aka.prototicket.entity.Role;
import com.aka.prototicket.entity.User;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UserPersistenceTests
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	@Transactional
	public void testSaveUserWithRoles() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		User user = new User();
		user.setRole(new Role());
		session.save(user);
		session.flush();
		assertNotNull(user.getId());
	}

	@Test
	@Transactional
	public void testSaveAndGet() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		User user = new User();
		user.setRole(new Role());
		session.save(user);
		session.flush();
		// Otherwise the query returns the existing user (and we didn't set the
		// parent in the role)...
		session.clear();
		User other = (User) session.get(User.class, user.getId());
		assertNotNull(other.getRole());
		assertEquals(other.getId(), user.getId());
		assertEquals(other.getLogin(), user.getLogin());
		assertEquals(other.getPassword(), user.getPassword());
	//	assertEquals(other.getEmail(), user.getEmail());
	}

}
