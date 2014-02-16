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


public class SleepForComputation
{

	
	@Test
	public void testPauseForComputation() throws InterruptedException
	{
		System.out.println("Sleeping for 30 seconds...");
		Thread.sleep(60000L);
	}
	

}
