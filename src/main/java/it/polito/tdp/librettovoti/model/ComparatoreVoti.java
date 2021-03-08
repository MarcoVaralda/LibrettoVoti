package it.polito.tdp.librettovoti.model;

import java.util.Comparator;

public class ComparatoreVoti implements Comparator<Voto>{

	@Override
	public int compare(Voto v1, Voto v2) {
		if(v1.getNome().toUpperCase().compareTo(v2.getNome().toUpperCase())>0)
			return 1;
		if(v1.getNome().toUpperCase().compareTo(v2.getNome().toUpperCase())<0)
			return -1;
		if(v1.getVoto()>=v2.getVoto())
			return -1;
		return 1;
	}

}
