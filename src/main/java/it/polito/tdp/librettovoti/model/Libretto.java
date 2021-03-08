package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {
	
	private List<Voto> voti;
	
	public List<Voto> getVoti() {
		return voti;
	}

	public Libretto() {
		this.voti = new ArrayList<>();
	}
	
	public void add (Voto v) {
		if(!this.voti.contains(v) || verificaVoto(v)!=null) 
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
	
	/**
	 * Cerca nel libretto il voto passato come parametro, ovvero un voto con la stessa
	 * valutazione e lo stesso nome di quello passato come parametro.
	 * null se non trovato
	 * @param v
	 * @return
	 */
	public Voto cercaVoto(Voto v) {
		for(Voto vv : this.voti)
			if(vv.getNome().equals(v.getNome()) && vv.getVoto()==v.getVoto())
				return vv;
		return null;
	}
	
	/**
	 * Verifica se esiste un esame nel libretto in conflitto con quelli presenti:
	 * stesso nome, ma con valutazione diversa.
	 * null se non sono presenti conflitti
	 * @param v
	 * @return
	 */
	public Voto verificaVoto(Voto v) {
		for(Voto vv : this.voti)
			if(vv.getNome().equals(v.getNome()) && vv.getVoto()!=v.getVoto())
				return vv;
		return null;
	}
	
	public String toString() {
		String s = "";
		for(Voto v : this.voti) {
			s = s +v.toString() +"\n";
		}
		return s;
	}

}
