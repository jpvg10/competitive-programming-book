import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxFlow {

	static ArrayList<Integer> g[];
	static int[] parent;
	static int[][] cap;
	static int[][] flow;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		g = new ArrayList[n];
		for(int i = 0; i < n; i++){
			g[i] = new ArrayList<Integer>();
		}
		parent = new int[n];
		cap = new int[n][n];
		flow = new int[n][n];

		for(int i=0; i<m; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			g[u].add(v);
			// Siempre se agrega esta arista, aunque el grafo sea dirigido
			g[v].add(u);
			cap[u][v] = c;
			// La siguiente linea solo se agrega si el grafo es no-dirigido
			// cap[v][u] = c;
		}

		int s = sc.nextInt();
		int t = sc.nextInt();
		int max = maxFlow(s, t);
	}

	public static int maxFlow(int s, int t) {
		int ans = 0;
		while(true) {
			Arrays.fill(parent, -1);
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(s);
			
			while(!q.isEmpty()) {
				int u = q.poll();
				if(u == t) break;

				int len = g[u].size();
				for(int i=0; i<len; i++){
					int v = g[u].get(i);
					if(parent[v] == -1 && cap[u][v] - flow[u][v] > 0){
						q.add(v);
						parent[v] = u;
					}
				}
			}
			if(parent[t] == -1) break;

			int bottleneck = Integer.MAX_VALUE;
			int end = t;
			while(end != s) {
				int start = parent[end];
				bottleneck = Integer.min(bottleneck, cap[start][end] - flow[start][end]);
				end = start;
			}

			end = t;
			while(end != s) {
				int start = parent[end];
				flow[start][end] += bottleneck;
				flow[end][start] = -flow[start][end];
				end = start;
			}

			ans += bottleneck;
		}
		return ans;
	}
}
