package com.example.restservice;

public class BetriebsstelleAlleInfos extends Betriebsstelle {

    private final String plc;
    private final String typ_k;
    private final String betriebszustand;
    private final String datumAb;  // represent date
    private final String datumBis;
    private final String niederlassung;
    private final String regionalbereich;
    private final String letzteAenderung;


    public BetriebsstelleAlleInfos(String plc, String rl100Code, String rl100Lang, String rl100Kurz, String typ_l, String typ_k, String betriebszustand, String datumAb, String datumBis, String niederlassung, String regionalbereich, String letzteAenderung) {

        super(rl100Code,rl100Lang,rl100Kurz,typ_l);
        this.plc = plc;
        this.typ_k = typ_k;
        this.betriebszustand = betriebszustand;
        this.datumAb = datumAb;
        this.datumBis = datumBis;
        this.niederlassung = niederlassung;
        this.regionalbereich = regionalbereich;
        this.letzteAenderung = letzteAenderung;
    }

    public String getPlc() {
        return plc;
    }


    public String getTyp_k() {
        return typ_k;
    }

    public String getBetriebszustand() {
        return betriebszustand;
    }

    public String getDatumAb() {
        return datumAb;
    }

    public String getDatumBis() {
        return datumBis;
    }

    public String getNiederlassung() {
        return niederlassung;
    }

    public String getRegionalbereich() {
        return regionalbereich;
    }

    public String getLetzteAenderung() {
        return letzteAenderung;
    }


}
