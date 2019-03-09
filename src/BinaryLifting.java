import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryLifting {

	static ArrayList<Integer> tree[];
	static HashMap<String, Integer> edgeWeight;
	static boolean[] seen;
	static int[] depth;
	static int maxDepth;
	static int[] parent;
	static int[][] table;
	static int[][] maxParentEdge;
	static int edge;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] l = br.readLine().split(" ");

		int n = Integer.parseInt(l[0]);

		edgeWeight = new HashMap<String, Integer>();
		tree = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n - 1; i++) {
			l = br.readLine().split(" ");
			int a = Integer.parseInt(l[0]) - 1;
			int b = Integer.parseInt(l[1]) - 1;
			int c = Integer.parseInt(l[2]);
			edgeWeight.put(a + "," + b, c);
			edgeWeight.put(b + "," + a, c);
			tree[a].add(b);
			tree[b].add(a);
		}

		seen = new boolean[n];
		depth = new int[n];
		depth[0] = 0;
		parent = new int[n];
		parent[0] = 0;

		bfs(0);

		buildTable(n);

		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			l = br.readLine().split(" ");
			int u = Integer.parseInt(l[0]) - 1;
			int v = Integer.parseInt(l[1]) - 1;

			int lowest = lca(u, v);
			int maxEdge = maxEdgeInPath(u, v);

			bw.write("The lowest common ancestor of (" + (u + 1) + "," + (v + 1) + ") is: " + (lowest + 1) + "\n");
			bw.write("The maximum edge in the path (" + (u + 1) + "," + (v + 1) + ") is: " + maxEdge + "\n");
		}

		bw.close();
	}

	private static void bfs(int u) {
		seen[u] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		while (!q.isEmpty()) {
			u = q.poll();
			int len = tree[u].size();
			for (int i = 0; i < len; i++) {
				int v = tree[u].get(i);
				if (!seen[v]) {
					seen[v] = true;
					parent[v] = u;
					depth[v] = depth[u] + 1;
					q.add(v);
				}
			}
		}
	}

	public static int log2(int n) {
		return 31 - Integer.numberOfLeadingZeros(n);
	}

	public static void buildTable(int n) {
		maxDepth = log2(n);

		table = new int[maxDepth + 1][n];
		maxParentEdge = new int[maxDepth + 1][n];

		for (int i = 0; i <= maxDepth; i++) {
			Arrays.fill(table[i], -1);
		}

		for (int i = 0; i < n; i++) {
			table[0][i] = parent[i];
			if (i != parent[i]) {
				maxParentEdge[0][i] = edgeWeight.get(i + "," + parent[i]);
			}
		}

		for (int d = 1; d <= maxDepth; d++) {
			for (int i = 0; i < n; i++) {
				int mid = table[d - 1][i];
				if (mid != -1) {
					table[d][i] = table[d - 1][mid];
					maxParentEdge[d][i] = Integer.max(maxParentEdge[d - 1][i], maxParentEdge[d - 1][mid]);
				}
			}
		}
	}

	public static int walk(int i, int k) {
		for (int d = 0; d <= maxDepth && i != -1; d++) {
			if (((1 << d) & k) > 0) {
				i = table[d][i];
			}
		}
		return i;
	}

	public static int walkWeight(int i, int k) {
		for (int d = 0; d <= maxDepth && i != -1; d++) {
			if (((1 << d) & k) > 0) {
				edge = Integer.max(edge, maxParentEdge[d][i]);
				i = table[d][i];
			}
		}
		return i;
	}

	public static int lca(int i, int j) {
		if (depth[i] > depth[j]) {
			i = walk(i, depth[i] - depth[j]);
		} else if (depth[j] > depth[i]) {
			j = walk(j, depth[j] - depth[i]);
		}

		if (i == j) {
			return i;
		}

		for (int d = maxDepth; d >= 0; d--) {
			if (table[d][i] != table[d][j]) {
				i = table[d][i];
				j = table[d][j];
			}
		}

		return table[0][i];
	}

	public static int maxEdgeInPath(int u, int v) {
		edge = -1;

		if (depth[u] > depth[v]) {
			u = walkWeight(u, depth[u] - depth[v]);
		} else if (depth[v] > depth[u]) {
			v = walkWeight(v, depth[v] - depth[u]);
		}

		if (u == v) {
			return edge;
		}

		for (int d = maxDepth; d >= 0; d--) {
			if (table[d][u] != table[d][v]) {
				edge = Integer.max(edge, maxParentEdge[d][u]);
				edge = Integer.max(edge, maxParentEdge[d][v]);
				u = table[d][u];
				v = table[d][v];
			}
		}

		edge = Integer.max(edge, maxParentEdge[0][u]);
		edge = Integer.max(edge, maxParentEdge[0][v]);
		return edge;
	}
}

class Edge implements Comparable<Edge> {
	public int u, v, cost;

	public Edge(int u, int v, int cost) {
		this.u = u;
		this.v = v;
		this.cost = cost;
	}

	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}
