package com.onlinestore.alternativeroutes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "routerecords")
public class RouteRecord {

	@Column(name = "service_name", nullable = false)
	String serviceName;
	@Column(name = "active", nullable = false)
	String active;
	@Column(name = "endpoint", nullable = false)
	String endpoint;
	@Column(name = "weight", nullable = false)
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
