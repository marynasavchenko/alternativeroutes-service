package com.onlinestore.alternativeroutes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Route record entity class.
 */
@Entity
@Table(name = "routerecords")
public class RouteRecord {

	@Id
	@Column(name = "service_name", nullable = false)
	String serviceName;

	@Column(name = "active_status", nullable = false)
	String activeStatus;

	@Column(name = "endpoint", nullable = false)
	String endpoint;

	@Column(name = "weight", nullable = false)
	Integer weight;

	public RouteRecord() {
	}

	public RouteRecord(String serviceName, String activeStatus, String endpoint, Integer weight) {
		this.serviceName = serviceName;
		this.activeStatus = activeStatus;
		this.endpoint = endpoint;
		this.weight = weight;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RouteRecord that = (RouteRecord) o;
		return Objects.equals(serviceName, that.serviceName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(serviceName);
	}
}
