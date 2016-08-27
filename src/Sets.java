import java.util.HashSet;

public class Sets {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();		
		//TreeSet<String> ts = new TreeSet<String>();	
		
		hs.add("Hola");
		hs.add("Hola");
		hs.add("Mundo");
		//Imprime 2, porque no se aceptan repetidos
		System.out.println(hs.size());
		
		//Recorrido
		for(String s: hs){
			System.out.println(s);
		}
	}

}
