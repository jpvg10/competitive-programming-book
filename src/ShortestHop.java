import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestHop {

	static ArrayList<Integer> g[];
	static boolean seen[];
	static int dist[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		seen = new boolean[n];
		dist = new int[n];
		g = new ArrayList[n];
		for(int i=0; i<n; i++){
			g[i] = new ArrayList<Integer>();
		}

		//Aca leer las aristas del grafo

		int s = 0;
		shortestHop(s);
		//Despues de llamar este metodo, en dist[i] esta la distancia mas corta (s,i)
	}

	public static void shortestHop(int u){
		//Distancia "infinita" hacia todos los nodos
		Arrays.fill(dist, Integer.MAX_VALUE);
		//Distancia 0 hacia el nodo de origen
		dist[u] = 0;

		seen[u] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		while(!q.isEmpty()){
			u = q.poll();
			int len = g[u].size();
			for(int i=0; i<len; i++){
				int v = g[u].get(i);
				if(!seen[v]){
					seen[v] = true;
					q.add(v);
					//Lo unico que cambia es que se calcula dist[v]
					dist[v] = dist[u] + 1;
				}
			}
		}
	}
}
