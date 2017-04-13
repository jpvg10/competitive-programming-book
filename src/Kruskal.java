import java.util.ArrayList;
import java.util.Collections;

//Se necesita implementar tambien la clase UnionFind

class Arista implements Comparable<Arista>{
	public int u, v, costo;
	public Arista(int u, int v, int costo){
		this.u = u;
		this.v = v;
		this.costo = costo;
	}
	public int compareTo(Arista o) {
		return this.costo - o.costo;
	}
}

public class Kruskal {

	public static void main(String[] args) {
		int n = 10; //Cantidad de nodos del grafo
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		int mst = kruskal(aristas, n);
	}

	public static int kruskal(ArrayList<Arista> aristas, int n){
		Collections.sort(aristas);

		UnionFind uf = new UnionFind(n);
		int costoMST = 0;
		int i = 0;
		while(uf.getComponents() != 1){
			Arista a = aristas.get(i);
			if(!uf.connected(a.u, a.v)){
				uf.union(a.u, a.v);
				costoMST += a.costo;
			}
			i++;
		}

		return costoMST;
	}
}
