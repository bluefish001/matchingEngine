package com.hoxie.matchingEngine.enity;

import java.util.Date;
import java.util.Set;

public class Job {
	private String guid;
	private int jobId;
	private String company;
	private String jobTitle;
	private String billRate;
	private int workersRequired;
	
	private boolean driverLicenseRequired;
	private Set<String> requiredCertificates;
	
	private Date startDate;
	private Location location;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getBillRate() {
		return billRate;
	}

	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}

	public int getWorkersRequired() {
		return workersRequired;
	}

	public void setWorkersRequired(int workersRequired) {
		this.workersRequired = workersRequired;
	}

	public boolean isDriverLicenseRequired() {
		return driverLicenseRequired;
	}

	public void setDriverLicenseRequired(boolean driverLicenseRequired) {
		this.driverLicenseRequired = driverLicenseRequired;
	}

	public Set<String> getRequiredCertificates() {
		return requiredCertificates;
	}

	public void setRequiredCertificates(Set<String> requiredCertificates) {
		this.requiredCertificates = requiredCertificates;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Override                       
	public int hashCode() {         
		
		final int PRIME = 31;
	    int result = 1;
	    result = PRIME * result + getJobId();
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

        Job e = (Job) o;

        return (this.getJobId() == e.getJobId());

	}
	
}
