package com.ravindra.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Provider implements Serializable {
	private static final long serialVersionUID = 2185893011944600234L;
	private Long id;
	private String providerId;
	private String providerName;
	private String providerType;
	private String ssn;
	private List<Address> serviceLocations;
}