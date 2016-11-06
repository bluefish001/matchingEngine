package com.hoxie.matchingEngine.service;

import java.util.List;

import com.hoxie.matchingEngine.enity.Job;
import com.hoxie.matchingEngine.enity.Worker;

public interface MatchService {

	public List<Job> findJobList(Worker worker, List<Job> jobList);
}
