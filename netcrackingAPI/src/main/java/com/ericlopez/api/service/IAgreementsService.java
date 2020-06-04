package com.ericlopez.api.service;


import org.json.simple.JSONObject;

import com.ericlopez.api.repository.IAgreement;

public interface IAgreementsService {
	//It should extract the data from a JSON object into the
	//specified classes
	public IAgreement create(JSONObject data);
	
	//It should create a file containing the JSON
	public String save();

	//it should read a file containing the JSON
	public JSONObject read(String name);
}
