package com.aka.prototicket.service.prediction.tests;

import junit.framework.Assert;

import org.junit.Test;

import com.aka.prototicket.service.prediction.testbase.ArtistRecommendationTestBase;


public class ArtistRecommendationGetRecommendations extends ArtistRecommendationTestBase
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
	public void testGetRecommendations() 
	{
		for(int i=0;i<genres.length;i++)
		{
			for(int j=0;j<NUMBER_USERS_PER_GENRE;j++)
			{
				
				String username = genres[i] + "user" + j;
				
				try
				{
				
					String[] recommendations = predictionHelper.getRecommendations(username, 2);
				
					for(int k=0;k<recommendations.length;k++)
					{
						System.out.println("User " + username + " is recommended going to see " + recommendations[k]);
					}
				}
				catch(RuntimeException ex)
				{
					System.out.println("Error getting recommendations for username: " + username + ".  Message:"  + ex.getMessage());
				}
				
			}
		}
	}
	
	
	
	
	
	

}
