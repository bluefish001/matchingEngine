package com.hoxie.matchingEngine.service.imp;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hoxie.matchingEngine.enity.Job;
import com.hoxie.matchingEngine.enity.Worker;
import com.hoxie.matchingEngine.service.RestFullClientService;

@Service("RestFullClientService")
public class RestFullClientServiceImp implements RestFullClientService {
		
	public List<Worker> getWorkerResponseList(String URL){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Worker>> response = restTemplate.exchange(URL,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Worker>>() {
        });
				 
		 
		 List<Worker> resposneList = response.getBody();
		 
		 return resposneList;
	}
	
	public List<Job> getJobResponseList(String URL){
		RestTemplate restTemplate = new RestTemplate();
		 ResponseEntity<List<Job>> response = restTemplate.exchange(URL,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Job>>() {
        });
				 		 
		 List<Job> resposneList = response.getBody();
		 
		 return resposneList;
	}

}
