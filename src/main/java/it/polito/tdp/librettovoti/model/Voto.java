package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

/**
 * Memorizza il risultato di un singolo esame
 * 
 * @author marco
 *
 */

public class Voto { // Questa classe è un semplice contenitore di dati, non li gestisce
	
	private String nome;
	private int voto; // Come rappresento il 30 L ?
	private LocalDate data; // Data superamento esame
	
	
	public Voto(String nome, int voto, LocalDate data) {
		this.nome = nome;
		this.voto = voto;
		this.data = data;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getVoto() {
		return voto;
	}


	public void setVoto(int voto) {
		this.voto = voto;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "Esame " + nome + " superato con " + voto + " in data " + data;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + voto;
		return result;
	}


	/*@Override
	public boolean equals(Object obj) {
		Voto altro = (Voto) obj;
		if(this.nome.equals(altro.nome) && this.voto==altro.voto)
			return true;
		return false;
	}*/
	
	
	

}
