package com.aka.prototicket.service.prediction.tests;

import io.prediction.Item;
import io.prediction.User;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aka.prototicket.service.prediction.testbase.PredictionHelperTestBase;

public class ArtistRecommendationCommissionTest extends PredictionHelperTestBase
{

	@Test 
	public void setup()
	{
		predictionHelper.setAppKey(ARTIST_RECOMMENDATION_APIKEY);
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
	public void testCreateItem()
	{
		predictionHelper.addUser("testuser");
		predictionHelper.addItem("artist1", new String[] { "artist" });
		Item item = predictionHelper.getItem("artist1");
		Assert.assertEquals("artist1", item.getIid());
		predictionHelper.deleteUser("testuser");
	}
	@Test
	public void testDeleteItem()
	{
		Item item = null;
		String msg = "";
		predictionHelper.addItem("artist1", new String[] { "artist" });
		predictionHelper.deleteItem("artist1");
		try
		{
			item = predictionHelper.getItem("artist1");
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
	public void testDeleteUser()
	{
		predictionHelper.addUser("testuser");
		predictionHelper.deleteUser("testuser");
		User user = predictionHelper.getUser("testuser");
		Assert.assertNull(user);
	}
	
}
