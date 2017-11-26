package clases;

import java.util.ArrayList;

public class Voto {
	private ArrayList<Candidato> info = new ArrayList<Candidato>();
	
	
	
	public Voto() {
		
	}

	public void imprimirVotos() {
		for (Candidato e : info) {
			String msg = e.getNombre() +" " + e.getAgrupacion();
			System.out.println(msg);
		}	
	}
	public void agregarCandidato(Candidato candidato) {
		info.add(candidato);
		
	}
	public Candidato sacar_eleccion() {
		for (Candidato e : info) {
			if(e.is_eliminado()) {
			}
			else {
				return e;
			}
		}
		return null;
	};
}
