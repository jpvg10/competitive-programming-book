import java.util.ArrayList;
import java.util.LinkedList;

public class TopoSort {

	static ArrayList<Integer> g[];
	static int seen[];
	static LinkedList<Integer> topoSort;

	public static void main(String[] args) {
		int n = 10;

		seen = new int[n];
		topoSort = new LinkedList<Integer>();
		g = new ArrayList[n];
		for(int i=0; i<n; i++){
			g[i] = new ArrayList<Integer>();
		}		

		boolean sinCiclo = true;
		//Es necesario hacer el ciclo para visitar todos los nodos
		for(int u=0; u<n; u++){
			if(seen[u] == 0){
				sinCiclo = topoDfs(u);
			}
		}

		if(sinCiclo){
			//La lista 'topoSort' contiene los nodos en su orden topologico
		}else{
			//Hay un ciclo
		}
	}

	private static boolean topoDfs(int u){
		//DFS "modificado" para hacer ordenamiento topologico
		//Se marca 'u' como 'gris'
		seen[u] = 1;
		int len = g[u].size();
		boolean sinCiclo = true;
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(seen[v] == 0){
				topoDfs(v);
			}else if(seen[v] == 1){
				//Hay un ciclo, retorna falso
				sinCiclo = false;
			}
		}
		//Se agrega el nodo 'u' al inicio de la lista y se marca como 'negro'
		seen[u] = 2;
		topoSort.addFirst(u);
		return sinCiclo;
	}

}
