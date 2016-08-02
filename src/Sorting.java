import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sorting {

	public static void main(String[] args) {
		String v[] = {"hola", "z", "mundo", "0", "aaaa", "quick", "sort", "1a"};

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(9); a.add(0); a.add(-1); a.add(25); a.add(7); a.add(1);

		//Ambos utilizan QuickSort
		//Collections.sort() tambien ordena LinkedList
		Arrays.sort(v);
		Collections.sort(a);

		for(int i=0; i<v.length; i++){
			System.out.print(v[i] + " ");
		}

		//Esto llama la funcion .size() y .get() cada vez
		//En ArrayList .get() es O(1) pero en LinkedList es O(n),
		//por lo cual hacer esto es fatal
		for(int i=0; i<a.size(); i++){
			System.out.print(a.get(i) + " ");
		}

		//Otra forma de hacerlo, pero no se tiene acceso a los indices de cada elemento
		for(int k : a){
			System.out.print(k + " ");
		}
	}

}
