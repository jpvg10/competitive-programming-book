import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Grafos {

	static ArrayList<Integer> g[];
	static boolean seen[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		seen = new boolean[n];
		g = new ArrayList[n];
		for(int i = 0; i < n; i++){
			g[i] = new ArrayList<Integer>();
		}

		while(sc.hasNextInt()){
			int u = sc.nextInt();
			int v = sc.nextInt();
			g[u].add(v);
			// Si el grafo es no-dirigido, tambien se agrega arista de v a u
			g[v].add(u);
		}

		//Visita solo los nodos que son alcanzables desde el nodo 's'
		int s = 0;
		dfs(s);

		//Con el vector 'seen' vemos cuales son estos nodos
		for(int i=0; i<n; i++){
			if(seen[i]){
				//'i' es alcanzable desde 's'
			}
		}

		//Si queremos visitar todos los nodos
		for(int u=0; u<n; u++){
			if(!seen[u]){
				//Si no hemos visitado 'u', hacer DFS en 'u'
				dfs(u);
			}
		}
	}

	private static void dfs(int u){
		seen[u] = true;
		int len = g[u].size();
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(!seen[v]){
				dfs(v);
			}
		}
	}

	private static void bfs(int u){
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
				}
			}
		}
	}
}
