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
	List<Betriebsstelle> betriebsstellen;

	public BetriebsstellenController(){
		dataLoader = new DataLoader();
		betriebsstellen = dataLoader.initializeData();
	}


	@GetMapping(value = "/betriebsstelle",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Betriebsstelle betriebsstelle(@RequestParam(value = "code", defaultValue = "aamp") String code) {
		Betriebsstelle result = null;
		try {
			result = findeBetriebsstelle(betriebsstellen,code);
		} catch (IndexOutOfBoundsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return result;
	}

	/** Gibt die gefundene Betriebsstelle zurück, wenn die Betriebsstelle mit übergebener Abkürzung in
	 * @param rl100Code Abkürzung der gesuchten Betriebsstelle
	 * @param  list zu durchsuchende Liste
	 */
	Betriebsstelle findeBetriebsstelle(List<Betriebsstelle> list, String rl100Code) throws IndexOutOfBoundsException {
		List<Betriebsstelle> result = list.stream()
				.filter(item -> item.getCode().equals(rl100Code.toLowerCase()))
				.collect(Collectors.toList());
		return result.get(0);
	}

}
