package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<>();
	}
	
	public void add (Voto v) {
		this.voti.add(v);
	}
	
	public List<Voto> listaVotiUguali(int punteggio) {
		List<Voto> risultato = new ArrayList<Voto>();
		for(Voto v : this.voti) 
			if(v.getVoto()==punteggio)
				risultato.add(v);
		return risultato;
	}
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato = new Libretto();
		for(Voto v : this.voti) 
			if(v.getVoto()==punteggio)
				risultato.add(v);
		return risultato;
	}
	
	/**
	 * Ricerca voto del corso passato come parametro.
	 * null se non trovato
	 * 
	 * @param nomeCorso
	 * @return
	 */
	public Voto cercaCorso(String nomeCorso) {
		Voto v = null;
		for(Voto vv : this.voti)
			if(vv.getNome().equals(nomeCorso)) {
				v = vv;
				break;
			}
		return v;
	}
	
	public String toString() {
		String s = "";
		for(Voto v : this.voti) {
			s = s +v.toString() +"\n";
		}
		return s;
	}

}
