import java.util.Collections;
import java.util.PriorityQueue;

public class ColaDePrioridad {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(3);
		pq.add(5);
		pq.add(1);
		pq.peek(); //No saca el 1 de la cola
		pq.poll(); //Saca el 1 de la cola y el 3 queda en la cabeza

		//Orden inverso
		PriorityQueue<Integer> pqInversa = new PriorityQueue<Integer>(Collections.reverseOrder());
		pqInversa.add(3);
		pqInversa.add(1);
		pqInversa.poll(); //Saca el 3
	}

}
