package com.ravindra.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;

@Entity(name="provider_tb")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Data
public class ProviderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "ID", initialValue = 1)
	@Column(name = "ID")
	private Long id;
	private String providerId;
	private String providerName;
	private String providerType;
	private String ssn;
	
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
	private List<AddressDocument> serviceLocations;
}