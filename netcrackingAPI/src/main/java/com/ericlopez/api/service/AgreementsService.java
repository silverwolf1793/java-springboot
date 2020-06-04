package com.ericlopez.api.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericlopez.api.repository.IAgreement;
import com.ericlopez.api.repository.IProduct;
import com.ericlopez.api.repository.Product;

@Service
public class AgreementsService implements IAgreementsService {

	//We initialize everything on the top
	//as it can be read, we create an empty agreement object and
	//all the support variables
	@Autowired
	private IAgreement ag;
	private JSONObject JSONdata;
	private String mainPath = "src//main//resources//agreements//";
	@SuppressWarnings("unchecked")
	
	//this its a private function that extracts the data from the json
	//and populates the products fields in the agreement object
	//its a recursive function, basically it does this:
	//create list of products -> populate product->has sons? 
	//y (populate...) n (return empty array) ->
	//save product into the list -> return list of products
	
	private ArrayList<IProduct> convert(ArrayList<Object> data,Object parent) {
	
		ArrayList<IProduct> prList = new ArrayList<IProduct>();
		

		
		for(Object val : data) {
			IProduct pBuffer = new Product();
			
			
			JSONObject item = new JSONObject((Map<String,Object>) val);
			
			ArrayList<Object> products = (ArrayList<Object>) item.get("products");
			
			pBuffer.setName((String) item.get("name"));
			pBuffer.setPrice((String) item.get("price"));
			
			if(parent != null)
				pBuffer.setParentObject(parent);
			
			if(products != null && products.size() > 0)
				pBuffer.setProducts(this.convert(products,pBuffer));
			
			prList.add(pBuffer);	
		}
		
		
		return prList;
	}

	//this populates the object agreement and
	//uses the convert function to extract all the products
	@SuppressWarnings("unchecked")
	@Override
	public IAgreement create(JSONObject data) {
		
		this.JSONdata = data;
		
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime time = LocalDateTime.now();
		
		ag.setName("Agreement "+ timeFormat.format(time));
		ag.setSignedBy((String) data.get("signed by"));
		ag.setProducts(this.convert((ArrayList<Object>) data.get("products"),ag));
		return ag;
	}
	
	//this function saves the data into a file
	//for the moment I just save the JSON file straight as 
	//the input of the user on the api, BUT it can be "upgraded"
	//we could implement a function that would use the clean values
	//of the object, but due to time I didn't implemented the 
	//JSON encoder, given an extra couple hours it could be done.
	@Override
	public String save() {
		String Response = "";
		
		try {
		  Path path = Paths.get( mainPath + this.ag.getName().replace('/', ' ').toLowerCase());
	      
	      FileWriter myObj = new FileWriter(path.toString(), false);
	      myObj.write(this.JSONdata.toJSONString());
	      myObj.close();
	      
	      Response = "File created: " + this.ag.getName();
	      
	    } catch (IOException e) {
	    	Response = "Error";
	      e.printStackTrace();
	    }
		
		return Response;
	}

	//this function its very simple
	//loads a file with a given name and
	//using the create function it creates the objects
	@Override
	public JSONObject read(String name) {
		Path path = Paths.get(mainPath + "\\agreement " + name);
		String data = "";
		JSONParser parser = new JSONParser();
		JSONObject result = null;
		
		try {
			File myObj = new File(path.toString());
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        data += myReader.nextLine();
		      }
		      myReader.close();
		      result = (JSONObject) parser.parse(data);
		}catch (IOException | ParseException e) {
		      e.printStackTrace();
	    }

		
		this.create(result);
		
		return result;
	}
	
	

}
