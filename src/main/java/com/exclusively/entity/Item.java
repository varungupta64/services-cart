package com.exclusively.entity;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Item{

@org.springframework.data.annotation.Id
@Field
private String Id;

@Field("SessionId")
private String SessionId;

@Field
private String UserId;

@Field
private String ItemId;

@Field
private String SellerCode;

//Getters-Setters
public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}

public String getSessionId() {
	return SessionId;
}

public void setSessionId(String sessionId) {
	SessionId = sessionId;
}

public String getUserId() {
	return UserId;
}

public void setUserId(String userId) {
	UserId = userId;
}

public String getItemId() {
	return ItemId;
}

public void setItemId(String itemId) {
	ItemId = itemId;
}

public String getSellerCode() {
	return SellerCode;
}

public void setSellerCode(String sellerCode) {
	SellerCode = sellerCode;
}
}

