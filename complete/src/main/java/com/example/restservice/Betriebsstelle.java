package com.example.restservice;

public class Betriebsstelle {


	private final String rl100Code;
	private final String rl100Lang;
	private final String rl100Kurz;
	private final String typ_l;



	public Betriebsstelle(String rl100Code, String rl100Lang, String rl100Kurz, String typ_l) {
		this.rl100Code = rl100Code;
		this.rl100Lang = rl100Lang;
		this.rl100Kurz = rl100Kurz;
		this.typ_l = typ_l;
	}


	public String getRl100Code() {
		return rl100Code;
	}

	public String getRl100Lang() {
		return rl100Lang;
	}

	public String getRl100Kurz() {
		return rl100Kurz;
	}

	public String getTyp_l() {
		return typ_l;
	}


}
