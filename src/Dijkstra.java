import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Nodo implements Comparable<Nodo>{
	int id, distancia;
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
	static int[] distancias, padre;
	static boolean[] visitado;
	static PriorityQueue<Nodo> proximo;	
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		g = new ArrayList[n];
		p = new int[n][n];
		distancias = new int[n];
		padre = new int[n];
		visitado = new boolean[n];
		proximo = new PriorityQueue<Nodo>();
		for (int i=0; i<n; i++) {
			g[i] = new ArrayList<Integer>();
			distancias[i] = Integer.MAX_VALUE;	
		}
		
		while(sc.hasNextInt()) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			g[u].add(v);
			g[v].add(u); //Si es no-dirigido
			p[u][v] = c;
			p[v][u] = c; //Si es no-dirigido
		}
		
		int src = 0;
		dijkstra(src);		
		//distancias[i] contiene la menor distancia entre 'src' e 'i'
		
		//Para hallar el camino como tal entre 'src' y un nodo
		LinkedList<Integer> camino = new LinkedList<Integer>();
		int r = 4;		
		camino.add(r);
		while(r != src){			
			r = padre[r];
			camino.addFirst(r);
		}
	}
	
	public static void dijkstra(int src){
		distancias[src] = 0;
		proximo.add(new Nodo(src, 0));
		padre[src] = src;
				
		while(!proximo.isEmpty()) {
			Nodo u = proximo.poll();
			if(!visitado[u.id]){
				visitado[u.id] = true;
				int len = g[u.id].size();
				for (int i=0; i<len; i++) {
					int v = g[u.id].get(i);
					if(u.distancia + p[u.id][v] < distancias[v]){
						distancias[v] = u.distancia + p[u.id][v];
						proximo.add(new Nodo(v, distancias[v]));
						padre[v] = u.id;
					}
				}
			}			
		}
	}
}
