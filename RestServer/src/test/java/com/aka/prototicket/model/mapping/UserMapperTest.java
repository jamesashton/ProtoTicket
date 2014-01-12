package com.aka.prototicket.model.mapping;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.aka.prototicket.db.entity.Role;
import com.aka.prototicket.db.entity.User;
import com.aka.prototicket.model.dto.UserDto;


@ContextConfiguration(locations = {"classpath:com/aka/prototicket/MapperTest-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest
{
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void testToDto()
	{
		User user = new User();
		user.setFirstname("firstname");
		user.setLastname("lastname");
		user.setEmail("email");
		user.setId(1);
		user.setLogin("login");
		user.setPassword("password");
		user.setRole(new Role());
		
		UserDto dto = userMapper.toDto(user);
		
		Assert.assertEquals("firstname", dto.getFirstname());
		Assert.assertEquals("lastname", dto.getLastname());
		Assert.assertEquals("email", dto.getEmail());
		Assert.assertEquals(new Integer(1),dto.getId());
		Assert.assertEquals("login", dto.getLogin());
		Assert.assertEquals("password",dto.getPassword());
		
		
	}

	@Test 
	public void testToEntity()
	{
		UserDto dto = new UserDto();
		dto.setFirstname("firstname");
		dto.setLastname("lastname");
		dto.setEmail("email");
		dto.setId(1);
		dto.setLogin("login");
		dto.setPassword("password");
		
		User entity = userMapper.toEntity(dto);
		
		Assert.assertEquals("firstname", entity.getFirstname());
		Assert.assertEquals("lastname", entity.getLastname());
		Assert.assertEquals("email", entity.getEmail());
		Assert.assertEquals(new Integer(1),entity.getId());
		Assert.assertEquals("login", entity.getLogin());
		Assert.assertEquals("password",entity.getPassword());
		Assert.assertNull(entity.getRole());
	}
}
