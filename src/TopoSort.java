import java.util.ArrayList;
import java.util.LinkedList;

public class TopoSort {

	static ArrayList<Integer> g[];
	static boolean seen[];
	static LinkedList<Integer> topoSort;

	public static void main(String[] args) {
		int nodes = 10;

		seen = new boolean[nodes];

		g = new ArrayList[nodes];
		for(int i = 0; i < nodes; i++){
			g[i] = new ArrayList<Integer>();
		}

		//Es necesario hacer el ciclo para visitar todos los nodos
		for(int u=0; u<nodes; u++){
			if(!seen[u]){
				dfs(u);
			}
		}

		//Despues de hacer los DFS, la lista 'topoSort'
		//contiene los nodos en su orden topologico
	}

	private static void dfs(int u){
		//DFS "modificado" para hacer ordenamiento topologico
		seen[u] = true;
		int adyLen = g[u].size();
		for(int i=0; i<adyLen; i++){
			int v = g[u].get(i);
			if(!seen[v]){
				dfs(v);
			}
		}
		//Lo unico que cambia es que se agrega el nodo 'u'
		//al inicio de esta lista
		topoSort.addFirst(u);
	}
}
