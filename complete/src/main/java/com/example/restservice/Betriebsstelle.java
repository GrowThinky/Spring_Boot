package com.example.restservice;

public class Betriebsstelle {


	private final String code;
	private final String name;
	private final String kurzname;
	private final String typ;


	public Betriebsstelle(String code, String name, String kurzname, String typ) {
		this.code = code;
		this.name = name;
		this.kurzname = kurzname;
		this.typ = typ;
	}


	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getKurzname() {
		return kurzname;
	}

	public String getTyp() {
		return typ;
	}


}
