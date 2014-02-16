package com.aka.prototicket.service.prediction.testbase;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aka.prototicket.service.prediction.PredictionHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ServiceTest-context.xml" })
public class PredictionHelperTestBase
{
	public static final int NUM_USERS = 10;
	public static final int NUM_ITEMS = 50;
	public static final int NUM_ITEMS_PER_USER = 10;
	
	public @Value("${prediction.test.artistRecommendation.apiKey}") String ARTIST_RECOMMENDATION_APIKEY;
	public @Value("${prediction.test.default.apiKey}") String PREDICTION_APIKEY;
	public @Value("${prediction.apiUrl}") String PREDICTION_APIURL;

	@Autowired
	public PredictionHelper predictionHelper;
	
	@Before
	public void setupPredictionHelper()
	{
		predictionHelper.setApiUrl(PREDICTION_APIURL);
	}
	
	
	
}
