package com.hoxie.matchingEngine.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hoxie.matchingEngine.enity.Worker;
import com.hoxie.matchingEngine.service.WorkerService;

@Service("WorkerService")
public class WorkerServiceImp implements WorkerService {
	private Logger log = LoggerFactory.getLogger(WorkerServiceImp.class);
	
	public Worker getWorkerById(int id,List<Worker> workerList){
		
		log.debug("worker list is "+workerList.size());
		Worker worker = new Worker(id);
		
		int index = workerList.indexOf(worker);
		log.debug("worker index is "+index);
		if(index>=0){
			return workerList.get(index);
		}
		
/*		for(Worker worker : workList)
			if(worker.getUserId()==id){
				return worker;
			}*/
		
		return null;
	}
}
