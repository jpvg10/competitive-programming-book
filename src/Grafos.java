import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafos {

	static ArrayList<Integer> g[];
	static boolean seen[];

	public static void main(String[] args) {
		int nodes = 10;

		seen = new boolean[nodes];

		g = new ArrayList[nodes];
		for(int i = 0; i < nodes; i++){
			g[i] = new ArrayList<Integer>();
		}

		int s = 0;

		//Visita SOLO los nodos que son alcanzables desde el nodo 's'
		dfs(s);

		//Con el vector 'seen' vemos cuales son estos nodos
		for(int i=0; i<nodes; i++){
			if(seen[i]){
				//'i' es alcanzable desde 's'
			}
		}

		//Si queremos visitar todos los nodos
		for(int u=0; u<nodes; u++){
			if(!seen[u]){
				//Si no hemos visitado 'u', hacer DFS en 'u'
				//Esto visitara todos los nodos alcanzables desde 'u'
				dfs(u);
			}
		}
	}

	private static void dfs(int source){
		seen[source] = true;
		int adyLen = g[source].size();
		for(int i=0; i<adyLen; i++){
			int v = g[source].get(i);
			if(!seen[v]){
				dfs(v);
			}
		}
	}

	private static void bfs(int source){
		Queue<Integer> queue = new LinkedList<Integer>();

		seen[source] = true;
		queue.add(source);

		while(!queue.isEmpty()){
			source = queue.poll();
			int adyLen = g[source].size();
			for(int i=0; i<adyLen; i++){
				int v = g[source].get(i);
				if(!seen[v]){
					seen[v] = true;
					queue.add(v);
				}
			}
		}
	}
}
