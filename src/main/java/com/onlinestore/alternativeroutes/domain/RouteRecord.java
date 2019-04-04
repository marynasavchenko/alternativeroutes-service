package com.onlinestore.alternativeroutes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Route record entity class.
 */
@Entity
@Table(name = "routerecords")
public class RouteRecord {
	/**
	 * Name of the service.
	 */
	@Id
	@Column(name = "service_name", nullable = false)
	String serviceName;
	/**
	 * Active status of route record. Can be "YES" or "NO".
	 */
	@Column(name = "active_status", nullable = false)
	String activeStatus;
	/**
	 * Endpoint of the service.
	 */
	@Column(name = "endpoint", nullable = false)
	String endpoint;
	/**
	 * Weight of the route.
	 */
	@Column(name = "weight", nullable = false)
	Integer weight;

	/**
	 * Constructs new empty {@code RouteRecord} instance.
	 */
	public RouteRecord() {
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getActiveStatus() {
		return activeStatus;
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

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
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
				", activeStatus='" + activeStatus + '\'' +
				", endpoint='" + endpoint + '\'' +
				", weight=" + weight +
				'}';
	}

}
