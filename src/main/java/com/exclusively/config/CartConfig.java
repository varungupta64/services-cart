package com.exclusively.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import com.exclusively.controller.CartController;
import com.exclusively.service.CartService;
import com.exclusively.service.CartServiceImpl;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.exclusively.repositories"})
public class CartConfig extends AbstractCouchbaseConfiguration {

	@Override
	protected List<String> bootstrapHosts() {
		// TODO Auto-generated method stub
		return Arrays.asList("127.0.0.1");
	}

	@Override
	protected String getBucketName() {
		return "asdf";
	}

	@Override
	protected String getBucketPassword() {
		return "";
	}
	
}
