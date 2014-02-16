package com.aka.prototicket.service.prediction.testbase;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;

public class ArtistRecommendationTestBase extends PredictionHelperTestBase
{
	protected static String[] genres;
	protected static Map<String,String[]> items;
	protected static int NUMBER_USERS_PER_GENRE = 2;

	@BeforeClass
	public static void init()
	{
		if(items == null)
		{
			System.out.println("Initialising ArtistRecommendationTestBase");
			items = new HashMap<String,String[]>();
			items.put("blues", new String[] { "Eric Clapton","Robert Johnson","Albert King","Robert Cray","Buddy Guy","Jimi Hendrix"});
			items.put("rock", new String[] { "Guns and Roses","Pearl Jam","The Who","The Cult",	"Jimi Hendrix","Eric Clapton"});
			items.put("country", new String[] { "Dolly Parton","Taylor Swift","Toby Keith","Kenny Chesney","Tom McGraw","Carry Underwood"});
			items.put("pop", new String[] { "Britney Spears","Taylor Swift","Beyonce","One Direction",	"Miley Cyrus","Little Mix" });
			genres = items.keySet().toArray(new String[items.keySet().size()]);
		}
	}
	
	
}
