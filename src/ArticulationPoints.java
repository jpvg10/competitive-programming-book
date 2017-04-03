import java.util.ArrayList;

public class ArticulationPoints {

	static ArrayList<Integer> g[];
	static boolean seen[];
	static int disc[];
	static int low[];
	static int time;
	static int parent[];
	static boolean ap[];

	public static void main(String[] args) {
		int n = 10;

		seen = new boolean[n];
		disc = new int[n];
		low = new int[n];
		time = 0;		
		ap = new boolean[n];
		g = new ArrayList[n];
		for(int i = 0; i < n; i++){
			g[i] = new ArrayList<Integer>();
		}
		parent = new int[n];
		for(int i=0; i<n; i++){
			parent[i] = -1;
		}

		for(int u=0; u<n; u++){
			if(!seen[u]){
				articulationPoints(u);
			}
		}
		//Si ap[i]==true, 'i' es un punto de articulacion
	}

	private static void articulationPoints(int u){
		seen[u] = true;
		disc[u] = time;
		low[u] = time;
		time++;
		int children = 0;

		int len = g[u].size();
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(!seen[v]){
				children++;
				parent[v] = u;
				articulationPoints(v);
				low[u] = Math.min(low[u], low[v]);
				if(parent[u] == -1 && children > 1){
					ap[u] = true;
				}else if(parent[u] != -1 && low[v] >= disc[u]){
					ap[u] = true;
				}
			}else if(v != parent[u]){
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}
}