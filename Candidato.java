package clases;

import java.io.File;
import java.util.ArrayList;

public class Candidato {
	private String nombre;
	private String agrupacion;
	private String color;
	private File foto;
	private boolean eliminado;
	public ArrayList<Voto> mis_votos = new ArrayList<Voto>(); 
	public String getNombre() {
		return nombre;
	}
	public Candidato(String nombre, String agrupacion, String color) {
		super();
		this.setNombre(nombre);
		this.setAgrupacion(agrupacion);
		this.setColor(color);
		this.eliminado = false;
	}
	
	public void agregar_a_mis_votos(Voto e) {
		mis_votos.add(e);
	}
	
	public void eliminar() {
		this.eliminado = true;
	}
	
	public boolean is_eliminado() {
		return this.eliminado;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAgrupacion() {
		return agrupacion;
	}
	public void setAgrupacion(String agrupacion) {
		this.agrupacion = agrupacion;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public File getFoto() {
		return foto;
	}
	public void setFoto(File foto) {
		this.foto = foto;
	}
	
}
