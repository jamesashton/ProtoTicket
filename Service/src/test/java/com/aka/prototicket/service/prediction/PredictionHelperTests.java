package com.aka.prototicket.service.prediction;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.aka.prototicket.service.prediction.tests.PredictionHelperRetrieveTest;
import com.aka.prototicket.service.prediction.tests.PredictionHelperTest;
import com.aka.prototicket.service.prediction.tests.SleepForComputation;

@RunWith(Suite.class)
@SuiteClasses({  PredictionHelperTest.class, SleepForComputation.class, PredictionHelperRetrieveTest.class, })
public class PredictionHelperTests
{

}
