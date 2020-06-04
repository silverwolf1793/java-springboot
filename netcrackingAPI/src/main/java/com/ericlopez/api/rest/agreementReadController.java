package com.ericlopez.api.rest;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericlopez.api.NetcrackingApiApplication;
import com.ericlopez.api.service.IAgreementsService;

@RestController
@RequestMapping("/agreement {data}")
public class agreementReadController implements IagreementReadController{
	
	@Autowired
	private IAgreementsService agreement;
	private static Logger LOG = LoggerFactory.getLogger(NetcrackingApiApplication.class);
	
	@GetMapping
	public JSONObject readData(@PathVariable("data") String Data){		
		LOG.info("Reading: "+ Data);
		return agreement.read(Data);
	}
}
