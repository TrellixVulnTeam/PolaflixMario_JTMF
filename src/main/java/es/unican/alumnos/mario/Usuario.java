package es.unican.alumnos.mario;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Usuario {

	public String nombre;
	public String contraseña;
	public String cuentaBancaria;
	public float cuotaFija;
	public List<Cargo> cargos;
	public RepertorioPersonal repertorioUsuario;
	public List<Serie> seriesNoMarcadas;
	
	
	
	public Usuario(String nombre, String contraseña, String cuentaBancaria, float cuotaFija,
			List<Usuario> amigos, List<Serie> seriesNoMarcadas) {

		setNombre(nombre);
		setContraseña(contraseña);
		setCuentaBancaria(cuentaBancaria);
		setCuotaFija(cuotaFija);
		setRepertorioUsuario(new RepertorioPersonal(this));
		setSeriesNoMarcadas(seriesNoMarcadas);
	}
	
	
	public float getCuotaFija() {
		return cuotaFija;
	}
	public void setCuotaFija(float cuotaFija) {
		this.cuotaFija = cuotaFija;
	}
	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	public RepertorioPersonal getRepertorioUsuario() {
		return repertorioUsuario;
	}
	public void setRepertorioUsuario(RepertorioPersonal repertorioUsuario) {
		this.repertorioUsuario = repertorioUsuario;
	}
	public List<Serie> getSeriesNoMarcadas() {
		return seriesNoMarcadas;
	}
	public void setSeriesNoMarcadas(List<Serie> seriesNoMarcadas) {
		this.seriesNoMarcadas = seriesNoMarcadas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	
	public void anhadirCapituloVisto(Serie serie, Temporada temporada, Capitulo capitulo) {
		cargos.get(cargos.size()-1).anhadirCargo(serie, temporada, capitulo);
	}
	
	public Cargo verCargo(Date fechaCargo) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(fechaCargo);
		for (Cargo c : cargos) {
			cal2.setTime(c.getFechaCargo());
			if(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)) {
				return c;
			}
		}
		return null;
	}
	
	public void agregarSerie(int idSerie) {
		repertorioUsuario.agregarSerie(idSerie);
	}
	
	public List<Serie> verSeriesOrdenadas(char letraInicial){
		List<Serie> seriesLetra = new LinkedList<Serie>();
		for(Serie s: seriesNoMarcadas) {
			if (s.getNombreSerie().charAt(0) == letraInicial) {
				seriesLetra.add(s);
			}
		}
		
		Collections.sort(seriesLetra);
		return seriesLetra;
		
	}
	
	public Serie verSeriesOrdenadas(String nombreSerie){
		for(Serie s: seriesNoMarcadas) {
			if (s.getNombreSerie().equals(nombreSerie)) {
				return s;
			}
		}
		
		return null;
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.getNombre()))
			return false;
		return true;
	}
	
	
	
}
