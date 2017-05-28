imporimport java.util.ArrayList;
import java.util.Stack;

public class Tarjan {

	static ArrayList<Integer> g[];
	static boolean[] seen, stackMember;
	static int[] disc, low, scc;
	static Stack<Integer> st;
	static int time, component;

	public static void main(String[] args) {
		int n = 10;

		seen = new boolean[n];
		stackMember = new boolean[n];
		disc = new int[n];
		low = new int[n];
		scc = new int[n];
		st = new Stack<Integer>();
		time = 0;
		component = 0;
		g = new ArrayList[n];
		for(int i = 0; i < n; i++){
			g[i] = new ArrayList<Integer>();
		}

		for(int u=0; u<n; u++){
			if(!seen[u]){
				tarjan(u);
			}
		}
		//scc[i]==x significa que 'i' pertenece a la componente 'x'
	}

	private static void tarjan(int u){
		seen[u] = true;
		st.add(u);
		stackMember[u] = true;
		disc[u] = time;
		low[u] = time;
		time++;

		int len = g[u].size();
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(!seen[v]){
				tarjan(v);
				low[u] = Math.min(low[u], low[v]);
			}else if(stackMember[v]){
				low[u] = Math.min(low[u], disc[v]);
			}
		}

		if(low[u] == disc[u]){
			int w;
			do{
				w = st.pop();
				stackMember[w] = false;
				scc[w] = component;
			}while(w != u);
			component++;
		}
	}

}
