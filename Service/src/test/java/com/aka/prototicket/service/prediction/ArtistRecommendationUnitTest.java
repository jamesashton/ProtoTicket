package com.aka.prototicket.service.prediction;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.prediction.Item;
import io.prediction.User;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ServiceTest-context.xml" })
public class ArtistRecommendationUnitTest extends PredictionHelperTestBase
{
	@Autowired
	PredictionHelper predictionHelper;
	String[] genres = new String[] {"blues","rock","country","pop"};
	Map<String,Item[]> items = new HashMap<String,Item[]>();
	int NUMBER_USERS_PER_GENRE = 2;
	
	@Test
	public void testGetStatus()
	{
		predictionHelper.setAppKey("U8pr8tR2jBRC6ZshJl1H9iSNu8oeQPjNSNVMqRcB82ONq3lotRO07EjCEocXQuTi");
		Assert.assertEquals("PredictionIO Output API is online.", predictionHelper.getStatus());
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
	@Test
	public void testCreateItems()
	{
		items.clear();
		
		// blues
		addArtists("blues", new String[] {
					"Eric Clapton",
					"Robert Johnson",
					"Albert King",
					"Robert Cray",
					"Buddy Guy",
					"Jimi Hendrix"
		});
		
		
		// rock
		addArtists("rock", new String[] {
					"Guns and Roses",
					"Pearl Jam",
					"The Who",
					"The Cult",
					"Jimi Hendrix",
					"Eric Clapton"
		});
		
		// country 
		addArtists("country", new String[] {
					"Dolly Parton",
					"Taylor Swift",
					"Toby Keith",
					"Kenny Chesney",
					"Tom McGraw",
					"Carry Underwood"
		});
		
		// pop
		addArtists("pop", new String[] {
				 	"Britney Spears",
				 	"Taylor Swift",
				 	"Beyonce",
				 	"One Direction",
				 	"Miley Cyrus",
				 	"Little Mix" });
		
		
	}
	private void addArtists( String genre,  String[] artistNames)
	{
			items.put(genre, createItems(artistNames, "artist"));
		
	}
	private Item[] createItems(String[] itemNames, String itemType)
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
		return items.toArray(new Item[items.size()]);
	}
	
	
	/*
	
	@Test
	public void testDeleteItems()
	{
		try
		{
			for(String key : items.keySet())
			{
				for(Item item : items.get(key))
				{
					predictionHelper.deleteItem(item.getIid());
					Item deletedItem = predictionHelper.getItem(item.getIid());
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
	*/
}
