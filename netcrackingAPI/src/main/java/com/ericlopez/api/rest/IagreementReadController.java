package com.ericlopez.api.rest;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IagreementReadController {
	//it should read the file with the saved JSON and create
	//all the objects with its respective fields as well as
	//returning the data to the user
	public JSONObject readData(@PathVariable("data") String Data);
}
