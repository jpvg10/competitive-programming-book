
public class Knapsack {

	public static void main(String[] args) {
		int n = 4;
		int W = 8;
		int values[] = {15, 10, 9, 5};
		int weights[] = {1, 5, 3, 4};

		//Tener cuidado: En la matriz los items se numeran 1...n y la capacidad de la mochila 1...W
		int A[][] = new int[n+1][W+1];

		//Aca se resuelve el problema. Asegurarse de tener los values y weights
		for (int i=1; i<=n; i++) {
			for (int x=0; x<=W; x++) {
				if (weights[i-1] > x) {
					A[i][x] = A[i-1][x];
				} else {
					int p = A[i-1][x];
					int q = A[i-1][x-weights[i-1]] + values[i-1];
					A[i][x] = (p > q) ? p : q;
				}
			}
		}

		//El valor maximo que se puede obtener es A[n][W]
		int solution = A[n][W];

		//Si se quiere determinar cuales items se incluyeron
		boolean chosen[] = new boolean[n];
		int i = n;
		int j = W;

		while(i>0){
			if(A[i][j] == A[i-1][j]){
				i--;
			}else{
				chosen[i-1] = true;
				i--;
				j = j-weights[i];
			}
		}
		//Si chosen[i]==true es porque i se incluyo
	}
}
