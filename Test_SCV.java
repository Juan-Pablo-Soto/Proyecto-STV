package test;

import java.util.ArrayList;

import clases.Candidato;
import clases.Puesto;
import clases.Voto;

public class Test_SCV {

	
	public Test_SCV() {
		super();
	}


	private ArrayList<Voto> votos = new ArrayList<Voto>();
	private Puesto puesto;
	int necesario;
	public void hacer_puesto(String nombre, String organizacion, int numero) {
		setPuesto(new Puesto(nombre,organizacion,numero));
	}
	public Puesto getPuesto() {
		return puesto;
	}
	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}
	public void crear_candidato(String nombre, String agrupacion, String color) {
		Candidato nuevo = new Candidato( nombre,  agrupacion,  color);
		puesto.corriendo.add(nuevo);
	}
	public void crear_necesario() {
	necesario = votos.size() / puesto.getNumero();
	}
	
	public int contar_votos() {
		System.out.println("La cantidad de votos es: ");
		System.out.println(votos.size());
		System.out.println("Los votos necesarios para ganar es");
		System.out.println(necesario);
		while(true) {

		
		if(puesto.getNumero()  - puesto.resultados.size() == puesto.corriendo.size()) {
			for(Candidato r: puesto.corriendo) {
				r.eliminar();
				puesto.resultados.add(r);
				System.out.printf("Este mae gano %s \n",r.getNombre());
			}
		}
		if(puesto.resultados.size() == puesto.getNumero()) {
			System.out.println("Ya terminaron las eleciones");			
			return 0;
		}
		

		for(Voto e : votos) {

			Candidato  aux = e.sacar_eleccion();
			if(aux!=null) {
				aux.agregar_a_mis_votos(e);
				for(Candidato r : puesto.corriendo) {
					if (r.mis_votos.size() >= necesario) {
						puesto.resultados.add(r);
						System.out.printf("Este mae gano %s \n",r.getNombre());
						r.eliminar();
						puesto.corriendo.remove(aux);
					}
				}
			}
	}

		System.out.printf("Se encuentra al mayor perdedor \n");

		Candidato perdedor = puesto.corriendo.get(0);
		for(Candidato r : puesto.corriendo) {
			System.out.printf("La cantidad de votos del candidato %s es %d \n",r.getNombre(),r.mis_votos.size());
			if(perdedor.mis_votos.size() > r.mis_votos.size()) {
				perdedor = r;
				
			}
		}
		
		
		perdedor.eliminar();
		puesto.corriendo.remove(perdedor);
		System.out.printf("El perdedor es: %s \n", perdedor.getNombre());
		for(Candidato r : puesto.corriendo) {
			r.mis_votos.removeAll(votos);
		}		
		
		

	}
	}
	
	
	public void votar(Voto pVoto) {
		votos.add(pVoto);
	}
	
	
	public void dar_ganadores() {
		System.out.printf("Los %d ganadares del puesto %s son \n",puesto.getNumero(), puesto.getNombre());
		
		for(Candidato r: puesto.resultados) {
			System.out.println(r.getNombre() + r.getAgrupacion() + r.getColor());
		}
	}
		
		
		
	}

	
	
	

	


