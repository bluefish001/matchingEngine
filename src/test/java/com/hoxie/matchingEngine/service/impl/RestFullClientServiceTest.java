package com.hoxie.matchingEngine.service.impl;

import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hoxie.matchingEngine.enity.Job;
import com.hoxie.matchingEngine.enity.Worker;
import com.hoxie.matchingEngine.service.imp.RestFullClientServiceImp;


public class RestFullClientServiceTest {

	@InjectMocks
	RestFullClientServiceImp restFullClientService;
	
	final String WORKERURL="http://swipejobs.azurewebsites.net/api/workers";
	final String JOBURL = "http://swipejobs.azurewebsites.net/api/jobs";
	
	@BeforeClass
	public void setUp(){
	      MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void getWorkerListTest(){
		List<Worker> workerList = restFullClientService.getWorkerResponseList(WORKERURL);
		Assert.assertEquals(workerList.size(), 50);
	}
	
	@Test
	public void getJobListTest(){
		List<Job> jobList = restFullClientService.getJobResponseList(JOBURL);
		Assert.assertEquals(jobList.size(), 40);
	}
	
	
	
}
