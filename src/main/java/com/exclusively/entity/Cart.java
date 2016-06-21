package com.exclusively.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import lombok.Data;

@Data
@Document
public class Cart {
	@Id
	@Field
	private String id;
	
	@Field
	private String created;
	
	@Field
	private String updated;
	
	@Field
	private boolean isGuest;
	
	@Field
	private Map<String,Integer> productQuantityMapping = new HashMap<String,Integer>();
	
}
