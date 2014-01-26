package com.aka.prototicket.service.prediction;

import java.util.Random;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ServiceTest-context.xml"})
public class PredictionHelperRetrieveTest
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
	public void testRetrieve()
	{
		int numUsers = 10;
		
		for(int i=0;i<numUsers;i++) 
		{
			String userId = "user" + i;
			
			String[] results = predictionHelper.getPrediction(userId);
			System.out.print("Top 5 for user " + userId);
			System.out.println(":" + StringUtils.join(results, ","));
			
		}
	}

}

