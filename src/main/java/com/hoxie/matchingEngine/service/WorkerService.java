package com.hoxie.matchingEngine.service;

import java.util.List;

import com.hoxie.matchingEngine.enity.Worker;

public interface WorkerService {
	public Worker getWorkerById(int id,List<Worker> workerList);
}
