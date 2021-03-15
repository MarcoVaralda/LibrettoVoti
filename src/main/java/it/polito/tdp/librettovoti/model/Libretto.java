package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Libretto {
	
	private List<Voto> voti ;
	private Map<String, Voto> votiMap ; // identity map: nome esame -> oggetto Voto
	
	public Libretto() {
		this.voti = new ArrayList<>() ;
		this.votiMap = new HashMap<>() ;
	}

	public void add(Voto v) {
		if(esisteDuplicato(v)==false && esisteConflitto(v)==false) {
			this.voti.add(v) ;
			this.votiMap.put(v.getNome(), v);
		}
	}
	
	/* blahhh...
	
	public void stampaVotiUguali(int punteggio) {
		// il Libretto stampa da solo i voti
		System.out.println();
	}
	
	public String votiUguali(int punteggio) {
		// calcola una stringa che contiene i voti
		// sarà poi il chiamante a stamparli
		// -> Solo il NOME?
		// -> Tutto il voto.toString()
	}
	*/
	
	public List<Voto> listaVotiUguali(int punteggio) {
		List<Voto> risultato = new ArrayList<>() ;
		for(Voto v: this.voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v) ;
			}
		}
		return risultato ;
	}
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato = new Libretto();
		for(Voto v: this.voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v) ;
			}
		}
		return risultato ;
	}
	
	/**
	 * Ricerca un Voto del corso di cui è specificato il nome
	 * Se il corso non esiste, restituisce null.
	 * @param nomeCorso
	 * @return
	 */
	public Voto ricercaCorso(String nomeCorso) {
//		Voto risultato = null ;
//		for(Voto v: this.voti) {
//			if(v.getNome().equals(nomeCorso)) {
//				risultato = v ;
//				break ;
//			}
//		}
//		return risultato ;
		return this.votiMap.get(nomeCorso) ;
	}
	
	/**
	 * Verifica se nel libretto c'è già un voto con lo stesso esame e la
	 * stessa votazione.
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
//		boolean trovato = false ;
//		for(Voto voto: this.voti) {
//			if(voto.getNome().equals(v.getNome()) && voto.getVoto()==v.getVoto()) {
//				trovato = true ;
//				break ;
//			}
//		}
//		return trovato ;
		
		Voto trovato = this.votiMap.get(v.getNome()) ;
		if(trovato==null)
			return false ;
		if(trovato.getVoto()==v.getVoto()) 
			return true;
		else
			return false ;
	}
	
	/**
	 * Verifica se nel libretto c'è già un voto con lo stesso esame ma
	 * votazione diversa.
	 * @param v
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
//		boolean trovato = false ;
//		for(Voto voto: this.voti) {
//			if(voto.getNome().equals(v.getNome()) && voto.getVoto()!=v.getVoto()) {
//				trovato = true ;
//				break ;
//			}
//		}
//		return trovato ;
		
		Voto trovato = this.votiMap.get(v.getNome()) ;
		if(trovato==null)
			return false ;
		if(trovato.getVoto()!=v.getVoto()) 
			return true;
		else
			return false ;
	}
	
	/**
	 * Restituisce un nuovo libretto in cui ogni voto è aumentato di 1 se compreso tra 18 e 23
	 * e di 2 se maggiore o uguale a 24. IN ogni caso il voto massimo è 30.
	 * @return
	 */
	public Libretto getLibrettoMigliorato() {
		Libretto librettoMigliorato = new Libretto();
		for(Voto v : this.voti) {
			if(v.getVoto()>=18 && v.getVoto()<24) {
				int nuovoVoto = v.getVoto()+1;
				librettoMigliorato.add(new Voto(v.getNome(),nuovoVoto,v.getData()));
			}
			if(v.getVoto()>=24 && v.getVoto()<28) {
				int nuovoVoto = v.getVoto()+2;
				librettoMigliorato.add(new Voto(v.getNome(),nuovoVoto,v.getData()));
			}
			if(v.getVoto()>=28)
				librettoMigliorato.add(new Voto(v.getNome(),30,v.getData()));
		}
		return librettoMigliorato;
	}
	
	/**
	 * Ordina il libretto alfabeticamente per nome esame e per voto decrescente
	 * @return
	 */
	public Libretto ordinaLibretto() {
		LinkedList<Voto> elenco = new LinkedList<Voto>(this.voti);
		Collections.sort(elenco);
		
		Libretto librettoOrdinato = new Libretto();
		for(Voto v : elenco)
			librettoOrdinato.add(v);
		return librettoOrdinato;
	}
	
	/**
	 * Elimina dal libretto tutti i voti inferiori a 24
	 */
	public void pulisciLibretto() {
		LinkedList<Voto> daEliminare = new LinkedList<Voto>();
		for(Voto v : this.voti)
			if(v.getVoto()<24)
				daEliminare.add(v);
		for(Voto v : daEliminare)
			this.voti.remove(v);
	}
		
	public String toString() {
		String s = "" ;
		for(Voto v: this.voti) {
			s = s + v.toString() + "\n" ;
		}
		return s ;
	}
}
