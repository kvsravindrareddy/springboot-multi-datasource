package com.ravindra.dbtwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravindra.dbtwo.entity.DbTwo;
import com.ravindra.dbtwo.repo.DbTwoRepo;

@RestController
public class DbTwoController {
	@Autowired
	public DbTwoRepo dbTwoRepo;
	
	@PostMapping(value="/dbtwo")
	public void saveDbOne(@RequestBody DbTwo dbTwo)
	{
		dbTwoRepo.save(dbTwo);
	}
}