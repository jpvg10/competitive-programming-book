import java.util.HashMap;
import java.util.Map.Entry;

//Contar el numero de veces que aparecen las palabras en un String
public class Mapas {

	public static void main(String args[]){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		//LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

		String s = "tres tristes tigres tragaban trigo en un trigal en tres tristes trastos";
		String palabras[] = s.split(" ");

		for(int i=0; i<palabras.length; i++){
			if(!hash.containsKey(palabras[i])){
				hash.put(palabras[i], 1);
			}else{
				hash.put(palabras[i], hash.get(palabras[i])+1);
			}
		}

		//Obtener un elemento
		System.out.println(hash.get("tres"));

		//Recorrer el mapa
		for(Entry<String, Integer> e : hash.entrySet()){
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}
}
