package com.ravindra.dbtwo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ravindra.dbtwo.entity.DbTwo;

@Repository
public interface DbTwoRepo extends CrudRepository<DbTwo, Long>{

}