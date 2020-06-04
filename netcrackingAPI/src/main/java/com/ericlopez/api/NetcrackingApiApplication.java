package com.ericlopez.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetcrackingApiApplication implements CommandLineRunner{	
	//didn't created unitary tests due to time
	//the whole project took me an evening, if
	//I were to dedicate it another evening I could have developed
	//with test driven development instead of agile development
	public static void main(String[] args) {
		SpringApplication.run(NetcrackingApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub		
	}
	
	
	

}
