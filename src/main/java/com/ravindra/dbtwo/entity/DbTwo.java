package com.ravindra.dbtwo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity(name="DB_TWO_TB")
public class DbTwo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID")
    @SequenceGenerator(
            name = "ID",
            sequenceName = "ID", initialValue=1
    )
	@Column(name = "ID", insertable=false, updatable=false)
	private Long id;
	private String name;
	private String address;
}