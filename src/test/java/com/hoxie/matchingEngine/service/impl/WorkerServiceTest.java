package com.hoxie.matchingEngine.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hoxie.matchingEngine.enity.Worker;
import com.hoxie.matchingEngine.service.imp.WorkerServiceImp;


public class WorkerServiceTest {
	
	@InjectMocks
	WorkerServiceImp workerService;
	
	@Spy
	List<Worker> workerList = new LinkedList<>();
	
	@BeforeClass
	public void setUp(){
	      MockitoAnnotations.initMocks(this);
	      setUpWorkerList();
	 }
	
	@Test
	public void getWorkerByIdTest(){
		
		Worker existingWork = workerService.getWorkerById(1, workerList);
		
		Assert.assertNotNull(existingWork);
		
		
	}
	
	private void setUpWorkerList(){
		Worker worker1 =new Worker();
		
		worker1.setUserId(1);
		worker1.setActived(true);
		worker1.setRating(1);
		
		workerList.add(worker1);
		
		Worker worker2 =new Worker();
		
		worker2.setUserId(2);
		worker2.setActived(false);
		worker2.setRating(2);
		
		workerList.add(worker2);
		
		
	}
	
}
