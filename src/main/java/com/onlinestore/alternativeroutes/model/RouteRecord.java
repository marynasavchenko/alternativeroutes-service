package com.onlinestore.alternativeroutes.model;

public class RouteRecord {

	String serviceName;
	String active;
	String endpoint;
	Integer weight;

	public RouteRecord() {
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getActive() {
		return active;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "RouteRecord{" +
				"serviceName='" + serviceName + '\'' +
				", active='" + active + '\'' +
				", endpoint='" + endpoint + '\'' +
				", weight=" + weight +
				'}';
	}

}
