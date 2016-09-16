import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
	
	static ArrayList<Integer> g[];
	static Nodo[] dist;
	static PriorityQueue<Nodo> proximo;
	static int[] parent;
	static int[][] p;
	
	public static void main(String[] args) throws IOException {
		int nodos = 5;
		
		g = new ArrayList[nodos];
		dist = new Nodo[nodos];
		parent = new int[nodos];
		proximo = new PriorityQueue<Nodo>();
		p = new int[nodos][nodos];
		
		for (int i = 0; i < nodos; i++) {
			g[i] = new ArrayList<Integer>();
			dist[i] = new Nodo(i, Integer.MAX_VALUE);				
		}
		
		int src = 0;
		int dest = 4;

		dist[src].peso = 0;
		proximo.add(dist[src]);
		parent[src] = src;
		
		Nodo a;
		while(!proximo.isEmpty()) {
			a = proximo.poll();
			calcularDistancia(a);
		}

		int mejorDistancia = dist[dest].peso;
		
		int r = dest;
		//bw.write(r+"\n");
		while(r != src){
			r = parent[r];
			//bw.write(r+"\n");
		}
		//bw.flush();
	}
	
	public static void calcularDistancia(Nodo u){
		int t = g[u.n].size();
		for (int i = 0; i < t; i++) {
			int x = g[u.n].get(i);
			if(u.peso + p[u.n][x] < dist[x].peso){
				dist[x].peso = u.peso + p[u.n][x];
				proximo.add(dist[x]);
				parent[x] = u.n;
			}
		}
	}
}

class Nodo implements Comparable<Nodo>{
	int n;
	int peso;

	public Nodo(int n, int peso){
		this.n = n;
		this.peso = peso;
	}
	
	public int compareTo(Nodo o) {
		return this.peso-o.peso;
	}
}
