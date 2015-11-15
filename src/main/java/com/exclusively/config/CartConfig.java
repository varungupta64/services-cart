package com.exclusively.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.exclusively.service"})
public class CartConfig extends AbstractCouchbaseConfiguration {

	@Override
	protected List<String> bootstrapHosts() {
		// TODO Auto-generated method stub
		return Arrays.asList("127.0.0.1");
	}

	@Override
	protected String getBucketName() {
		// TODO Auto-generated method stub
		return "cart";
	}

	@Override
	protected String getBucketPassword() {
		// TODO Auto-generated method stub
		return "";
	}
}
