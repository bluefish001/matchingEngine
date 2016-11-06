package com.hoxie.matchingEngine.enity;

public class JobSearchAddress{
	private String unit;
	private double maxJobDistance;
	private double longitude;
	private double latitude;
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getMaxJobDistance() {
		return maxJobDistance;
	}
	public void setMaxJobDistance(double maxJobDistance) {
		this.maxJobDistance = maxJobDistance;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}
