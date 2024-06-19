package com.sunovaa.spring_boot_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serialNumber;
    private String portNumber;
    private String type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
