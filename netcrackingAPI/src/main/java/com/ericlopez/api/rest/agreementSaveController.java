package com.ericlopez.api.rest;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericlopez.api.NetcrackingApiApplication;
import com.ericlopez.api.service.IAgreementsService;

@RestController
@RequestMapping("/agreement")
public class agreementSaveController implements IagreementSaveController{
	
	@Autowired
	private IAgreementsService agreement;
	private static Logger LOG = LoggerFactory.getLogger(NetcrackingApiApplication.class);
		
	@PostMapping
	public boolean create(@RequestBody JSONObject data ){
		
		LOG.debug("Extracting data from JSON");
		this.agreement.create(data);
		
		LOG.debug("Saving Data");
		String message = this.agreement.save();
		
		LOG.info(message);
		
		return true;
	}
}
