import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Nodo implements Comparable<Nodo>{
	int id;
	int distancia;
	public Nodo(int id, int distancia){
		this.id = id;
		this.distancia = distancia;
	}	
	public int compareTo(Nodo o) {
		return this.distancia-o.distancia;
	}
}

public class Dijkstra {
	
	static ArrayList<Integer> g[];
	static int[][] p;
	static Nodo[] nodos;
	static int[] padre;
	static boolean[] visited;
	static PriorityQueue<Nodo> proximo;	
		
	public static void main(String[] args) throws IOException {
		int n = 8;
		
		g = new ArrayList[n];
		p = new int[n][n];
		nodos = new Nodo[n];
		padre = new int[n];
		visited = new boolean[n];
		proximo = new PriorityQueue<Nodo>();
				
		for (int i=0; i<n; i++) {
			g[i] = new ArrayList<Integer>();
			nodos[i] = new Nodo(i, Integer.MAX_VALUE);				
		}
		
		//Aca empieza Dijkstra. Llenar antes 'g' y 'p' (lsita y matriz de adyacencia)
		int src = 0;		
		nodos[src].distancia = 0;
		proximo.add(nodos[src]);
		padre[src] = src;
				
		while(!proximo.isEmpty()) {
			Nodo u = proximo.poll();
			if(!visited[u.id]){
				visited[u.id] = true;
				int len = g[u.id].size();
				for (int i=0; i<len; i++) {
					int v = g[u.id].get(i);
					if(u.distancia + p[u.id][v] < nodos[v].distancia){
						nodos[v].distancia = u.distancia + p[u.id][v];
						proximo.add(nodos[v]);
						padre[v] = u.id;
					}
				}
			}			
		}
		
		//El vector 'nodos' contiene la menor distancia de 'src' a todos los nodos
		//Por ejemplo, la menor distancia de 'src' a 4 es
		int menorDist = nodos[4].distancia;
		
		//Para hallar el camino como tal entre 'src' y un nodo
		LinkedList<Integer> camino = new LinkedList<Integer>();
		int r = 4;		
		camino.add(r);
		while(r != src){			
			r = padre[r];
			camino.addFirst(r);
		}
	}
}
