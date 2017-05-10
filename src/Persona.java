import java.util.ArrayList;
import java.util.Collections;

class Persona implements Comparable<Persona>{
	public String nombre;
	public int edad;
	public Persona(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;
	}
	public int compareTo(Persona obj) {
		return this.edad - obj.edad;
	}
}

class Main {
	public static void main(String[] args) {
		ArrayList<Persona> p = new ArrayList<Persona>();
		p.add(new Persona("Carlos", 20));
		p.add(new Persona("Juan", 20));
		Collections.sort(p);
	}
}
