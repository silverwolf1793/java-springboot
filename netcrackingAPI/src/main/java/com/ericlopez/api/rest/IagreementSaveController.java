package com.ericlopez.api.rest;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IagreementSaveController {
	//it should create a new agreement and create all the
	//structures with its respective fields
	public boolean create(@RequestBody JSONObject data );
}
