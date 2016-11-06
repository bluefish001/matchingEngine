package com.hoxie.matchingEngine.enity;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



class Name{
	private String last;
	private String first;
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
public class Worker {
	private String guid;
	private  int userId;
	
	private int rating;
	private boolean actived;
	private Set<String> certificates;
	private Set<String> skills;
	private String transportation;
	private boolean hasDriversLicense;
	private String Email;
	private String phone;
	
	private JobSearchAddress jobSearchAddress;
	private Name name;
	private List<Availability> availability;
	
	public Worker(){
	}
	
	public Worker(int id){
		this.userId = id;
	}
	
	public List<Availability> getAvailability() {
		return availability;
	}
	public void setAvailability(List<Availability> availability) {
		this.availability = availability;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public Set<String> getCertificates() {
		return certificates;
	}
	public void setCertificates(Set<String> certificates) {
		this.certificates = certificates;
	}
	public Set<String> getSkills() {
		return skills;
	}
	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public boolean isHasDriversLicense() {
		return hasDriversLicense;
	}
	public void setHasDriversLicense(boolean hasDriversLicense) {
		this.hasDriversLicense = hasDriversLicense;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public JobSearchAddress getJobSearchAddress() {
		return jobSearchAddress;
	}
	public void setJobSearchAddress(JobSearchAddress jobSearchAddress) {
		this.jobSearchAddress = jobSearchAddress;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	
	public Set<Integer> getAviliabilityDay(){
		Set<Integer> AviliabilityDaySet = new TreeSet<>();
		if(getAvailability().size()>=0){
			for(Availability availability:getAvailability()){
				AviliabilityDaySet.add(availability.getDayIndex());
			}
		}
		
		return AviliabilityDaySet;
	}

	@Override                       
	public int hashCode() {         
		
		final int PRIME = 31;
	    int result = 1;
	    result = PRIME * result + getUserId();
	    return result;       
	}
	
	@Override
	public  boolean equals(Object o) {

        if(o == null)
        {

            return false;
        }

        if (o == this)
        {
           return true;
        }

        if (getClass() != o.getClass())
        {
            return false;
        }

        Worker e = (Worker) o;

        return (this.getUserId() == e.getUserId());

	}
}
