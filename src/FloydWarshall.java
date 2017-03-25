
public class FloydWarshall {

	public static void main(String[] args) {
		int n = 5;
		int grafo[][] = new int[n][n];
		int A[][] = new int[n][n];

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(i == j){
					grafo[i][j] = 0;
				}else{
					grafo[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		//Tener la matriz del grafo llena antes de hacer esto
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				A[i][j] = grafo[i][j];
			}
		}

		for(int k=0; k<n; k++){
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					int option1 = A[i][j];
					int option2;
					if(A[i][k] == Integer.MAX_VALUE || A[k][j] == Integer.MAX_VALUE){
						option2 = Integer.MAX_VALUE;
					}else{
						option2 = A[i][k] + A[k][j];
					}
					A[i][j] = Math.min(option1, option2);
				}
			}
		}

		//Verificar si el grafo tiene un ciclo negativo
		boolean negativeCycle = false;
		for(int i=0; i<n && !negativeCycle; i++){
			if(A[i][i] < 0){
				negativeCycle = true;
			}
		}
	}

}
