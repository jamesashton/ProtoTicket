package com.aka.prototicket.service.prediction.tests;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import io.prediction.Item;
import io.prediction.User;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aka.prototicket.service.prediction.testbase.ArtistRecommendationTestBase;


public class ArtistRecommendationSetupUsers extends ArtistRecommendationTestBase
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
	public void testDeleteUsers()
	{
		for(int i=0;i<genres.length;i++)
		{
			for(int j=0;j<NUMBER_USERS_PER_GENRE;j++)
			{
				String username = genres[i] + "user" + j;
				predictionHelper.deleteUser(username);
				User user = predictionHelper.getUser(username);
				Assert.assertNull(user);
			}
		}
	}
	
	@Test
	public void testCreateUsers()
	{
		for(int i=0;i<genres.length;i++)
		{
			for(int j=0;j<NUMBER_USERS_PER_GENRE;j++)
			{
				String username = genres[i] + "user" + j;
				predictionHelper.addUser(genres[i] + "user" + j);
				User user = predictionHelper.getUser(username);
				Assert.assertNotNull(user);
			}
		}	
	}
	
	
	
	

}
