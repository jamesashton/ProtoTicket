package com.aka.prototicket.service.prediction;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.aka.prototicket.service.prediction.tests.ArtistRecommendationCommissionTest;
import com.aka.prototicket.service.prediction.tests.ArtistRecommendationGetRecommendations;
import com.aka.prototicket.service.prediction.tests.ArtistRecommendationPerformActions;
import com.aka.prototicket.service.prediction.tests.ArtistRecommendationSetupItems;
import com.aka.prototicket.service.prediction.tests.ArtistRecommendationSetupUsers;
import com.aka.prototicket.service.prediction.tests.SleepForComputation;

@RunWith(Suite.class)
@SuiteClasses({ 
		ArtistRecommendationCommissionTest.class,
		ArtistRecommendationSetupItems.class,
		ArtistRecommendationSetupUsers.class,
		ArtistRecommendationPerformActions.class,
		SleepForComputation.class,
		ArtistRecommendationGetRecommendations.class
		})
public class ArtistRecommendationTests
{

}
