package es.unican.alumnos.mario.domainModel;


import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Temporada  implements Comparable<Temporada>{

	@Id
	@GeneratedValue
	protected int id;
	public int numTemporada;
	@OneToMany
	public List<Capitulo> capitulos;
	
	public Temporada() {}
	
	public Temporada(int numTemporada, List<Capitulo> capitulos) {
		setNumTemporada(numTemporada);
		setCapitulos(capitulos);
	}
	public int getNumTemporada() {
		return numTemporada;
	}
	public void setNumTemporada(int numTemporada) {
		if (numTemporada <= 0) {
			throw new RuntimeException("Número de temporada menor que 1");
		}
		this.numTemporada = numTemporada;
	}
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(List<Capitulo> capitulos) {
		Collections.sort(capitulos);
		this.capitulos = capitulos;
	}
	public Capitulo verCapitulo(int numCapitulo) {
		return capitulos.get(numCapitulo - 1);
	}
	
	@Override
	public int compareTo(Temporada u) {
	    if (this.numTemporada < 0 || u.getNumTemporada() < 0) {
	      return 0;
	    }
	    if(this.numTemporada < u.getNumTemporada()) {
	    	return -1;
	    }else if(this.numTemporada > u.getNumTemporada()) {
	    	return 1;
	    }else{
	    	return 0;
	    }
	  }
	
}