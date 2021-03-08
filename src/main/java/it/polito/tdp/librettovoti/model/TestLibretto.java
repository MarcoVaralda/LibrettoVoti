package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.*;

public class TestLibretto {
	
	public static void main(String[] args) {
		
		// Punto 1
		
		System.out.println("***** PUNTO 1 *****\n");
		
		System.out.println("Test metodi di libretto:");		
		Libretto libretto = new Libretto();
		
		Voto voto1 = new Voto("Analisi 1", 30, LocalDate.of(2019, 2, 15));
		libretto.add(voto1);
		
		libretto.add(new Voto("Chimica", 25, LocalDate.of(2019, 9, 15)));
		libretto.add(new Voto("Fisica 1", 28, LocalDate.of(2019, 7, 15)));
		libretto.add(new Voto("Informatica", 24, LocalDate.of(2019, 9, 15)));
		
		System.out.println(libretto);
		
		// Punto 2
		
		System.out.println("***** PUNTO 2 *****\n");
		
		// Prima soluzione con le liste (Nella stampa ho però le parentesi quadre
		/*
		List<Voto> venticinque = libretto.listaVotiUguali(25);
		System.out.println(venticinque);
		*/

		// Seconda soluzione con il libretto ( migliore perchè ho un metodo di stampa implementato da me
		System.out.println("Cerco Voti con punteggio pari a 25:");
		Libretto librettoVenticinque = libretto.votiUguali(25);
		System.out.println(librettoVenticinque);
		
		// Punto 3
		
		System.out.println("***** PUNTO 3 *****\n");
		
		System.out.println("Cerco voto del corso di Informatica:");
		Voto v = libretto.cercaCorso("Informatica");
		if(v!=null)
			System.out.println(v.getVoto()+"\n");
		else
			System.out.println("Il voto cercato non è presente nel libretto\n");
		
		// Punto 4
		
		System.out.println("***** PUNTO 4 *****\n");
		
		Voto daCercare = libretto.cercaVoto(voto1);
		System.out.println("Cerco l'esame di Analisi 1 nel libretto:");
		
		if(daCercare==null)
			System.out.println("Il voto cercato non è presente nel libretto!\n");
		else
			System.out.println(daCercare+"\n");
		
		// Punto 5
		
		System.out.println("***** PUNTO 5 *****\n");
		
		Voto daVerificare = libretto.verificaVoto(new Voto("Fisica 1", 28, LocalDate.of(2019, 7, 15)));
		System.out.println("Cerco conflitti per l'esame di Fisica 1:");
		
		if(daVerificare==null)
			System.out.println("Il voto cercato non presenta conflitti!\n");
		else
			System.out.println("E' presente un conflitto: il voto registrato nel libretto è: " +daVerificare+"\n");
				
		
		// Punto 6
		
		// Modifiche effettuate nel metodo add della classe Libretto
		
		// Punto 7
		
		System.out.println("***** PUNTO 7 *****\n");
		
		Libretto librettoMigliorato = new Libretto();
		int votoTemp=0;
		
		for(Voto vv : libretto.getVoti()) {
			Voto vtemp = null;
			if(vv.getVoto()>=18 && vv.getVoto()<24) {
				votoTemp=vv.getVoto()+1;
				vtemp = new Voto(vv.getNome(),votoTemp,vv.getData());
			}
			if(vv.getVoto()>=24 && vv.getVoto()<29) {
				votoTemp=vv.getVoto()+2;
				vtemp = new Voto(vv.getNome(),votoTemp,vv.getData());
			}
			if(vv.getVoto()==30 || vv.getVoto()==29)
				vtemp = new Voto(vv.getNome(),30,vv.getData());

			if(vtemp!=null)
				librettoMigliorato.add(vtemp);			
		}
		
		System.out.println("Stampo il libretto: \n"+libretto);
		System.out.println("Stampo il libretto migliorato: \n"+librettoMigliorato);
			
		// Punto 8
		
		System.out.println("***** PUNTO 8 *****\n");
		
		Libretto l = libretto.ordinaLibretto();
		System.out.println("Ordino il libretto: \n"+l+"\n");
		
	}	

}
