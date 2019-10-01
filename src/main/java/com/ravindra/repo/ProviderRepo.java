package com.ravindra.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ravindra.entity.ProviderEntity;

@Repository
public interface ProviderRepo extends CrudRepository<ProviderEntity, Long>{
	Optional<ProviderEntity> findByProviderId(String providerId);
	void deleteByProviderId(String providerId);
}