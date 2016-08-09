import java.util.ArrayList;
import java.util.LinkedList;

public class TopoSort {
	
	static ArrayList<Integer> g[];
	static int seen[];
	static LinkedList<Integer> topoSort;

	public static void main(String[] args) {
		int nodes = 10;
		
		seen = new int[nodes];
		topoSort = new LinkedList<Integer>();
		
		g = new ArrayList[nodes];
		for(int i = 0; i < nodes; i++){
			g[i] = new ArrayList<Integer>();
		}
		
		boolean ciclo = false;
		
		//Es necesario hacer el ciclo para visitar todos los nodos
		for(int u=0; u<nodes; u++){
			if(seen[u] == 0){				
				if(!dfs(u)){
					//Hay un ciclo en el grafo
					ciclo = true;
					break;
				}
			}
		}
		
		if(ciclo){
			//Hay un ciclo
		}else{
			//La lista 'topoSort' contiene los nodos en su orden topologico
		}
	}
	
	private static boolean dfs(int u){
		//DFS "modificado" para hacer ordenamiento topologico
		//Se marca 'u' como 'gris'
		seen[u] = 1;
		int adyLen = g[u].size();
		for(int i=0; i<adyLen; i++){
			int v = g[u].get(i);
			if(seen[v] == 0){
				return dfs(v);
			}else if(seen[v] == 1){
				//Hay un ciclo, retorna falso
				return false;
			}
		}
		//Se agrega el nodo 'u' al inicio de esta lista y se marca 'negro'
		seen[u] = 2;
		topoSort.addFirst(u);
		return true;
	}

}
