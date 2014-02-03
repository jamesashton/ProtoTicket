package com.aka.prototicket.service.prediction;

import java.util.Random;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ServiceTest-context.xml"})
public class PredictionHelperRetrieveTest extends PredictionHelperTestBase
{
	@Autowired
	PredictionHelper predictionHelper;
	
	@Before
	public void init()
	{
		predictionHelper.initialise();
	}
	
	@Test
	public void testGetStatus()
	{
		Assert.assertEquals("PredictionIO Output API is online.", predictionHelper.getStatus());
	}
	
	
	@Test
	public void testGetRecommentations()
	{

		for(int i=0;i<NUM_USERS;i++) 
		{
			String userId = "user" + i;
			
			String[] results = predictionHelper.getRecommendations(userId,5);
			System.out.print("Top 5 recommendations for user " + userId);
			System.out.println(":" + StringUtils.join(results, ","));
			
		}
	}
	
	//@Test
	public void testGetSimilar()
	{
		for(int i=0;i<NUM_ITEMS;i++) 
		{
			String itemId = "item" + i;
			
			String[] results = predictionHelper.getSimilar(itemId, 5);
			System.out.print("Top 5 similar items to " + itemId);
			String items = StringUtils.join(results, ",");
			System.out.println(": " + ((items!=null)?items:"No similar items found."));
		}
	}
}

