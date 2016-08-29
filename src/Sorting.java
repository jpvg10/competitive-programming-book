import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sorting {

	public static void main(String[] args) {
		int n = 10;
		String v[] = new String[n];
		ArrayList<Integer> l = new ArrayList<Integer>();

		//Ambos utilizan QuickSort
		//Collections.sort() tambien ordena LinkedList
		Arrays.sort(v);
		Collections.sort(l);

		//Esto llama la funcion .size() y .get() cada vez
		//En ArrayList .get() es O(1) pero en LinkedList es O(n), por lo cual hacer esto es fatal
		for(int i=0; i<l.size(); i++){
			System.out.println(l.get(i));
		}

		//La forma eficiente
		for(int k : l){
			System.out.println(k);
		}
	}

}