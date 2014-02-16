package com.aka.prototicket.service.prediction.tests;

import java.util.Random;

import io.prediction.Item;
import io.prediction.User;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aka.prototicket.service.prediction.testbase.PredictionHelperTestBase;

public class PredictionHelperTest extends PredictionHelperTestBase
{
	@Before
	public void setup()
	{
		predictionHelper.setAppKey(PREDICTION_APIKEY);
		predictionHelper.initialise();
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
		predictionHelper.addItem("item1", new String[] { "itemrec" });
		Item item = predictionHelper.getItem("item1");
		Assert.assertEquals("item1", item.getIid());
		predictionHelper.deleteItem("item1");
	}

	@Test
	public void testDeleteItem()
	{
		Item item = null;
		String msg = "";
		predictionHelper.addItem("item1", new String[] { "itemrec" });
		predictionHelper.deleteItem("item1");
		try
		{
			item = predictionHelper.getItem("item1");
		}
		catch(RuntimeException e)
		{
			msg = e.getMessage();
		}
		finally
		{
			Assert.assertNull(item);
			Assert.assertTrue(msg.equals("java.io.IOException: {\"message\":\"Cannot find item.\"}"));
		}
	}

	@Test
	public void testActionOnItem()
	{

		for (int i = 0; i < NUM_USERS; i++)
		{
			predictionHelper.addUser("user" + i);
		}
		for (int i = 0; i < NUM_ITEMS; i++)
		{
			predictionHelper.addItem("item" + i, new String[] { "itemrec" });
		}

		Random rnd = new Random();

		for (int i = 0; i < NUM_USERS; i++)
		{
			predictionHelper.identify("user" + i);
			for (int j = 0; j < NUM_ITEMS_PER_USER; j++)
			{
				predictionHelper.recordViewActionOnItem("user" + i,"item" + rnd.nextInt(NUM_ITEMS));
			}
		}


	}

	// @Test
	public void clearUsers()
	{

		for (int i = 0; i < NUM_USERS; i++)
		{
			predictionHelper.deleteUser("user" + i);
		}
		for (int i = 0; i < NUM_ITEMS; i++)
		{
			predictionHelper.deleteItem("item" + i);
		}

	}
}
