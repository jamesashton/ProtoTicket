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


public class ArtistRecommendationSetupItems extends ArtistRecommendationTestBase
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
	public void testDeleteItems()
	{
		try
		{
			for(String key : items.keySet())
			{
				for(String item : items.get(key))
				{
					predictionHelper.deleteItem(item);
					Item deletedItem = null;
					try
					{
						deletedItem = predictionHelper.getItem(item);
					}
					catch(Exception ex)
					{
						// ignore exceptions
					}
					Assert.assertNull(deletedItem);
					
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void testCreateItems()
	{
		addArtists(items.get("blues"));
		addArtists(items.get("rock"));
		addArtists(items.get("country"));
		addArtists(items.get("pop"));	
	}


	private void addArtists( String[] artistNames)
	{
		createItems(artistNames, "artist");
	}
	private void createItems(String[] itemNames, String itemType)
	{
		ArrayList<Item> items = new ArrayList<Item>();
		try
		{
			
			for(int i=0;i<itemNames.length;i++)
			{
	
				predictionHelper.addItem(itemNames[i], new String[] { itemType });
				Item item = predictionHelper.getItem(itemNames[i]);
				Assert.assertEquals(itemNames[i], URLDecoder.decode(item.getIid(),"utf-8"));
				items.add(item);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
