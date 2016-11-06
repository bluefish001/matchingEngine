package com.hoxie.matchingEngine.service.imp;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hoxie.matchingEngine.enity.Job;
import com.hoxie.matchingEngine.enity.Worker;
import com.hoxie.matchingEngine.service.MatchService;

@Service("MatchService")
public class MatchServiceImp implements MatchService{
	private Logger log = LoggerFactory.getLogger(MatchServiceImp.class);
	/*
	 * This method is not used
	 */
	public List<Job> findJobListBeforeJava8(Worker worker, List<Job> jobList){
		List<Job> jobs = new LinkedList<>();
		for(Job job:jobList){
			//check Driver License
			if(job.isDriverLicenseRequired()&&!worker.isHasDriversLicense()){
				continue;
			}
			//check required Certificates
			if(!worker.getCertificates().containsAll(job.getRequiredCertificates())){
				continue;
			}
			
			//check the location
			double distance = getDistance(worker.getJobSearchAddress().getLatitude(),
						worker.getJobSearchAddress().getLongitude(),job.getLocation().getLatitude(),job.getLocation().getLongitude(),worker.getJobSearchAddress().getUnit());
			if(distance>worker.getJobSearchAddress().getMaxJobDistance()){
				continue;
			}
			
			//check the time
			
			jobs.add(job);
			if(jobs.size()>=3){
				break;
			}
		}
		
		return jobs;
	}
	
	// match the proper job for worker
	public List<Job> findJobList(Worker worker, List<Job> jobList){
		List<Job> jobs = new LinkedList<>();
/*		jobList.parallelStream().forEach(job->{
			if(isMatchingJob(worker,job)){
				jobs.add(job);
			}	
		});
		*/
		jobs= jobList.stream()
				.filter(job->isMatchingJob(worker,job))
				.limit(3)
				.collect(Collectors.toList());
		log.debug("***************jobs size is "+jobs.size());
		return jobs;
	}
	
	private boolean isMatchingJob(Worker worker,Job job){
		//check Driver License
		if(job.isDriverLicenseRequired()&&!worker.isHasDriversLicense()){
			log.debug("Drivers License is not match for job"+job.getJobId());
			return false;
		}
		
		//check required Certificates
		if(!worker.getCertificates().containsAll(job.getRequiredCertificates())){
			log.debug("Certificates are not match for job"+job.getJobId());
			return false;
		}
		
		//check the location
		double distance = getDistance(worker.getJobSearchAddress().getLatitude(),
					worker.getJobSearchAddress().getLongitude(),job.getLocation().getLatitude(),job.getLocation().getLongitude(),worker.getJobSearchAddress().getUnit());
		if(distance>worker.getJobSearchAddress().getMaxJobDistance()){
			log.debug("location is not match for job"+job.getJobId());
			return false;
		}
		
		//check the time
		if(job.getStartDate()!=null){
			LocalDate date = job.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if(!worker.getAviliabilityDay().contains(date.getDayOfWeek().getValue())){
				log.debug("date is not match for job"+job.getJobId());
				return false;
			}
			
		}
								
		return true;
	}
	
	//calculate the distance
	//copy from http://www.geodatasource.com/developers/java
	private  double getDistance(double lat1, double lon1, double lat2, double lon2, String unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "KM") {
			dist = dist * 1.609344;
		} else if (unit == "N") {
			dist = dist * 0.8684;
		}

		return (dist);
	}
	
	private  double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	private  double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}
