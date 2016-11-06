package com.hoxie.matchingEngine.service;

import java.util.List;

import com.hoxie.matchingEngine.enity.Job;
import com.hoxie.matchingEngine.enity.Worker;

public interface RestFullClientService {
	public List<Worker> getWorkerResponseList(String URL);
	
	public List<Job> getJobResponseList(String URL);
}
