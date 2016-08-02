import java.util.ArrayList;
import java.util.LinkedList;

public class ShortestHop {

	static ArrayList<Integer> g[];
	static boolean seen[];
	static int dist[];

	public static void main(String[] args) {
		int nodes = 10;

		seen = new boolean[nodes];
		dist = new int[nodes];

		g = new ArrayList[nodes];
		for(int i = 0; i < nodes; i++){
			g[i] = new ArrayList<Integer>();
		}

		int s = 0;
		shortestHop(s);
		//Despues de llamar este metodo, en
		//dist[i] esta la distancia mas corta (s,i)
	}

	public static void shortestHop(int s){
		int n = g.length;

		//Distancia "infinita" hacia todos los nodos
		//Distancia 0 hacia el nodo de origen
		for(int i=0; i<n; i++){
			dist[i] = Integer.MAX_VALUE;
		}
		dist[s] = 0;

		//BFS "modificado"
		LinkedList<Integer> queue = new LinkedList<Integer>();

		seen[s] = true;
		queue.add(s);

		while(!queue.isEmpty()){
			s = queue.poll();
			int adyLen = g[s].size();
			for(int i=0; i<adyLen; i++){
				int w = g[s].get(i);
				if(!seen[w]){
					seen[w] = true;
					queue.add(w);
					//Lo unico que cambia es que se calcula el dist[w]
					dist[w] = dist[s] + 1;
				}
			}
		}
	}
}
