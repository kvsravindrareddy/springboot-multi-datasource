package com.ravindra.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class AddressDocument implements Serializable {
	private static final long serialVersionUID = 2108047718924418317L;
	private String addressType;
	private String street;
	private String state;
	private String zipCode;
	private String country;
}