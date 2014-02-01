package com.aka.prototicket.service.prediction;

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
public class FirstBandUnitTest extends PredictionHelperTestBase
{
	@Autowired
	PredictionHelper predictionHelper;

	@Test
	public void testGetStatus()
	{
		predictionHelper.setAppKey("qWifoXu91RuLVP3P53g0KEszvWQDR5IitZdQJNkrqRRT7Btn4d6mAo7DIP742ceq");
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
		predictionHelper.addItem("item1", new String[] { "itemrec" });
		Item item = predictionHelper.getItem("item1");
		Assert.assertEquals("item1", item.getIid());
		predictionHelper.deleteItem("item1");
	}
	
	
}
