package com.ravindra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ravindra.model.Provider;
import com.ravindra.service.ProviderService;

@RestController
@RefreshScope
public class ProviderRestController {

	@Autowired
	private ProviderService providerService;

	/*@Value("${test.prop}")
	private String testProp;

	@GetMapping(value = "/hello")
	public String hello() {
		return testProp;
	}*/

	@PostMapping(value = "/provider")
	public void createProvider(@RequestBody Provider provider) {
		providerService.createProvider(provider);
	}

	@GetMapping(value = "/provider")
	public Provider getProvider(@RequestParam(value = "providerId", required = false) String providerId) {
		return providerService.getProvider(providerId);
	}

	@GetMapping(value = "/providers")
	public List<Provider> getProviders() {
		return providerService.getProviders();
	}

	@PutMapping(value = "/provider")
	public void updateProvider(@RequestBody Provider provider) {
		providerService.updateProvider(provider);
	}

	@DeleteMapping(value = "/provider")
	public void deleteProvider(@RequestParam(value = "providerId", required = false) String providerId) {
		providerService.deleteProvider(providerId);
	}
}