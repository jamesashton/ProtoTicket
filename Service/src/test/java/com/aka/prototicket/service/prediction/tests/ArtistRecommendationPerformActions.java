package com.aka.prototicket.service.prediction.tests;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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


public class ArtistRecommendationPerformActions extends ArtistRecommendationTestBase
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
	public void testViewAction()
	{
		System.out.println("Number of entries:" + items.size());
		for(int i=0;i<genres.length;i++)
		{
			for(int j=0;j<NUMBER_USERS_PER_GENRE;j++)
			{
				String username = genres[i] + "user" + j;
				String[] itemIds = items.get(genres[i]);
				int nextIndex = new Random().nextInt(itemIds.length-1);
				predictionHelper.recordViewActionOnItem(username,itemIds[nextIndex]);
				System.out.println("User "+username+" has viewed "+itemIds[nextIndex] );
			}
		}
	}
	@Test
	public void testBuyAction()
	{
		for(int i=0;i<genres.length;i++)
		{
			for(int j=0;j<NUMBER_USERS_PER_GENRE;j++)
			{
				String username = genres[i] + "user" + j;
				String[] itemIds = items.get(genres[i]);
				int nextIndex = new Random().nextInt(itemIds.length-1);
				predictionHelper.recordBuyActionOnItem(username,itemIds[nextIndex]);
				System.out.println("User "+username+" has purchased a ticket to "+itemIds[nextIndex] );
			}	
		}
	}
	@Test
	public void testRateAction()
	{
		for(int i=0;i<genres.length;i++)
		{
			for(int j=0;j<NUMBER_USERS_PER_GENRE;j++)
			{
				String username = genres[i] + "user" + j;
				String[] itemIds = items.get(genres[i]);
				int nextIndex = new Random().nextInt(itemIds.length-1);
				int rating = new Random().nextInt(4) + 1;
				predictionHelper.recordRateActionOnItem(username,itemIds[nextIndex], rating);
				System.out.println("User "+username+" has rated a ticket to "+itemIds[nextIndex]+" with a rating of " + rating );
			}	
		}
	}

	

}
