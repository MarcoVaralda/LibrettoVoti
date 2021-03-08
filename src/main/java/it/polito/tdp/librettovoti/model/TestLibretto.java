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
		Libretto librettoVenticinque = libretto.votiUguali(25);
		System.out.println(librettoVenticinque);
	}	

}
