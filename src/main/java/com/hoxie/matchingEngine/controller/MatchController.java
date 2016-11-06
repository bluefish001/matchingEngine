package com.hoxie.matchingEngine.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoxie.matchingEngine.enity.Job;
import com.hoxie.matchingEngine.enity.Worker;
import com.hoxie.matchingEngine.service.MatchService;
import com.hoxie.matchingEngine.service.RestFullClientService;
import com.hoxie.matchingEngine.service.WorkerService;
import com.hoxie.matchingEngine.service.imp.MatchServiceImp;
import com.hoxie.matchingEngine.service.imp.WorkerServiceImp;

@RestController
public class MatchController {
	
	private Logger log = LoggerFactory.getLogger(MatchController.class);
	@Configuration
	@PropertySources(value = {@PropertySource("classpath:application.properties")})
    static class DefaultProperties
    {}
	
    @Resource
	//@Autowired
    private Environment env;
    
    @Autowired
    WorkerService workerService;
    
    @Autowired
    MatchService matchService;
    
    @Autowired
    RestFullClientService restFullClientService;
    
    @SuppressWarnings("unused")
	@RequestMapping(value="/matchedJob/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Job>> getMathcedJobByUserID( @PathVariable int id){
    	
    	 if(id<0){
    		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
    	 }
    	 
    	 // get resource url
    	 String workerURL = env.getRequiredProperty("workers.location");
    	 String jobURL = env.getRequiredProperty("jobs.location");
    	 
    	 log.debug("The workerURL is "+ workerURL);
    	 log.debug("The jobURL is "+ jobURL);
    	 
    	 // if cannot read from file, use default one
    	 if(workerURL==null||workerURL.equals("")){
    		 workerURL = "http://swipejobs.azurewebsites.net/api/workers";
    	 }
    	 
    	 if(jobURL==null||jobURL.equals("")){
    		 jobURL = "http://swipejobs.azurewebsites.net/api/jobs";
    	 }
    	 
    	 // get all workers
    	 List<Worker> workerList = restFullClientService.getWorkerResponseList(workerURL);
		 
		 // get all jobs
    	 List<Job> jobList = restFullClientService.getJobResponseList(jobURL);
		 		 
		 WorkerServiceImp workerService = new WorkerServiceImp();
		 
		 // find the worker from worker list
		 Worker worker = workerService.getWorkerById(id, workerList);
		 
		 
		 if(worker==null){
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		 }
		 
		 log.debug("The Worker is "+ worker.getPhone());
		
		 // match the job by worker's user id		 
		 MatchServiceImp matchService = new MatchServiceImp();
		 List<Job> matchedJobList = matchService.findJobList(worker, jobList);

		 
		 if(matchedJobList==null||matchedJobList.size()<=0){
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 
		 if(matchedJobList.size()>3){
			 matchedJobList= matchedJobList.subList(0, 3);
		 }
		 
		 log.debug("The value is "+ matchedJobList.get(0));
		 
		 return new ResponseEntity<>(matchedJobList,HttpStatus.OK);
    	
    }
    

}
