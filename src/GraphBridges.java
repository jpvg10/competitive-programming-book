import java.util.ArrayList;

class Bridge {
	public int u, v;
	public Bridge(int u, int v){
		this.u = u;
		this.v = v;
	}
}

public class GraphBridges {

	static ArrayList<Integer> g[];
	static boolean[] seen;
	static int[] disc, low, parent;
	static int time;
	static ArrayList<Bridge> bridgeEdges;

	public static void main(String[] args) {
		int n = 10;

		g = new ArrayList[n];
		seen = new boolean[n];
		disc = new int[n];
		low = new int[n];
		parent = new int[n];
		time = 0;
		bridgeEdges = new ArrayList<Bridge>();
		for(int i = 0; i < n; i++){
			g[i] = new ArrayList<Integer>();
			parent[i] = -1;
		}

		for(int u=0; u<n; u++){
			if(!seen[u]){
				bridges(u);
			}
		}
		//'bridgeEdges' contiene objetos tipo Bridge que indican que la arista u,v es un puente
	}

	private static void bridges(int u){
		seen[u] = true;
		disc[u] = time;
		low[u] = time;
		time++;

		int len = g[u].size();
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(!seen[v]){
				parent[v] = u;
				bridges(v);
				low[u] = Math.min(low[u], low[v]);
				if(low[v] > disc[u]){
					Bridge b = new Bridge(u, v);
					bridgeEdges.add(b);
				}
			}else if(v != parent[u]){
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}
}
