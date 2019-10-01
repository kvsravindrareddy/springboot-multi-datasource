package com.ravindra.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Address implements Serializable {
	private static final long serialVersionUID = 3777257687626521917L;
	private String addressType;
	private String street;
	private String state;
	private String zipCode;
	private String country;	
}