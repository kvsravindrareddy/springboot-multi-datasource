package com.ravindra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ravindra.entity.ProviderEntity;
import com.ravindra.model.Provider;
import com.ravindra.repo.ProviderRepo;

@Service
public class ProviderService {

	@Autowired
	private ProviderRepo providerRepo;

	@Caching(put = { @CachePut(value = "providerCache", key = "#provider.providerId") }, evict = {
			@CacheEvict(value = "allProvidersCache", allEntries = true) })
	public void createProvider(Provider provider) {
		System.out.println("....Inside Create method....");
		Gson gson = new Gson();
		String json = gson.toJson(provider);
		/*
		 * String json = null; if(StringUtils.isBlank(json)) { throw new
		 * InvalidRequestBodyException("......Request Json is blank......"); }
		 */
		ProviderEntity entity = gson.fromJson(json, ProviderEntity.class);
		providerRepo.save(entity);
	}

	@Cacheable(value = "providerCache", key = "#provider.providerId")
	public Provider getProvider(String providerId) {
		System.out.println("....Inside getProvider method....");
		ProviderEntity entity = providerRepo.findByProviderId(providerId).get();
		Gson gson = new Gson();
		String json = gson.toJson(entity);
		Provider provider = gson.fromJson(json, Provider.class);
		return provider;
	}

	@Caching(evict = { @CacheEvict(value = "providerCache", key = "#provider.providerId"),
			@CacheEvict(value = "allProvidersCache", allEntries = true) })
	public void deleteProvider(String providerId) {
		System.out.println("....Inside deleteProvider method....");
		providerRepo.deleteByProviderId(providerId);
	}

	@Caching(put = { @CachePut(value = "providerCache", key = "#provider.providerId") }, evict = {
			@CacheEvict(value = "allProvidersCache", allEntries = true) })
	public void updateProvider(Provider provider) {
		System.out.println("....Inside updateProvider method....");
		Gson gson = new Gson();
		String json = gson.toJson(provider);
		ProviderEntity entity = gson.fromJson(json, ProviderEntity.class);
		providerRepo.save(entity);
	}

	@Cacheable(value = "allProvidersCache")
	public List<Provider> getProviders() {
		System.out.println("....Inside getProviders method....");
		Iterable<ProviderEntity> itr = providerRepo.findAll();
		Gson gson = new Gson();
		String json = gson.toJson(itr);
		List<Provider> providerList = gson.fromJson(json, new TypeToken<List<Provider>>() {
		}.getType());
		return providerList;
	}

}