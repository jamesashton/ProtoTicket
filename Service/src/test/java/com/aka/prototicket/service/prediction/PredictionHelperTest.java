package com.aka.prototicket.service.prediction;

import io.prediction.User;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ServiceTest-context.xml"})
public class PredictionHelperTest
{
	@Autowired
	PredictionHelper predictionHelper;
	
	@Before
	public void setupPredictionHelper()
	{
		predictionHelper.setAppKey("7AenrKRwa475GhjqFNnu7MHQLayOgSxBW5uW4dSYeE8eJNBVCS53ZpnofGGPqaG2");
		
	}
	
	
	@Test
	public void testGetStatus()
	{
		Assert.assertEquals("PredictionIO Output API is online.", predictionHelper.getStatus());
	}
	
	@Test
	public void testCreateUser()
	{
		predictionHelper.addUser("testuser");
		User user = predictionHelper.getUser("testuser");
		Assert.assertEquals("testuser", user.getUid());
		
		
	}
	@Test
	public void testDeleteUser()
	{
		predictionHelper.deleteUser("testuser");
		User user = predictionHelper.getUser("testuser");
		Assert.assertNull(user);
	}
}
