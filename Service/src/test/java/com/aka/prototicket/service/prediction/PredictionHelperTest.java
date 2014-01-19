package com.aka.prototicket.service.prediction;

import io.prediction.Item;
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
	
	@Test
	public void testGetStatus()
	{
		predictionHelper.setAppKey("7AenrKRwa475GhjqFNnu7MHQLayOgSxBW5uW4dSYeE8eJNBVCS53ZpnofGGPqaG2");
		Assert.assertEquals("PredictionIO Output API is online.", predictionHelper.getStatus());
	}
	
	@Test
	public void testCreateUser()
	{
		predictionHelper.addUser("testuser");
		User user = predictionHelper.getUser("testuser");
		Assert.assertEquals("testuser", user.getUid());
		predictionHelper.deleteUser("testuser");
	}
	@Test
	public void testDeleteUser()
	{
		predictionHelper.addUser("testuser");
		predictionHelper.deleteUser("testuser");
		User user = predictionHelper.getUser("testuser");
		Assert.assertNull(user);
	}
	@Test
	public void testCreateItem()
	{
		predictionHelper.addUser("testuser");
		predictionHelper.addItem("item1",new String[]{"1"});
		Item item = predictionHelper.getItem("item1");
		Assert.assertEquals("item1",item.getIid());
		predictionHelper.deleteItem("item1");
	}
	@Test
	public void testDeleteItem()
	{
		predictionHelper.addItem("item1", new String[]{"1"});
		predictionHelper.deleteItem("item1");
		Item item = predictionHelper.getItem("item1");
		Assert.assertNull(item);
	}
}
