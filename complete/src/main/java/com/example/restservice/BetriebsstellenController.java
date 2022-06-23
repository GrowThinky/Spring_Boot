package com.example.restservice;


import java.util.*;
import java.util.stream.Collectors;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



@RestController
public class BetriebsstellenController {

	DataLoader dataLoader;
	HashMap<String,Betriebsstelle> betriebsstellen;

	public BetriebsstellenController(){
		dataLoader = new DataLoader();
		betriebsstellen = dataLoader.initializeData();
	}


	@GetMapping(value = "/betriebsstelle",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Betriebsstelle betriebsstelle(@RequestParam(value = "code", defaultValue = "aamp") String code) {
		Betriebsstelle result = null;
		result = betriebsstellen.get(code);
		 if(result == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return result;
	}



}
