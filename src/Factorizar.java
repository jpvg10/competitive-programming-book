import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Factorizar {

	static int menorFactor[];
	static ArrayList<Integer> primos;

	public static void cribaFactores(int n){
		menorFactor = new int[n+1];
		Arrays.fill(menorFactor, -1);
		primos = new ArrayList<Integer>();

		for(int i=2; i<=n; i++){
			if(menorFactor[i] == -1){
				primos.add(i);
				//OJO: Si esta teniendo problemas de overflow, cambie la siguiente linea por j = 2*i
				int j = i*i;
				while(j <= n){
					if(menorFactor[j] == -1){
						menorFactor[j] = i;
					}
					j = j+i;
				}
			}
		}
	}

	// Se debe incluir el metodo cribaFactores
	public static void main(String[] args) {
		//Por ejemplo, si el mayor valor posible es 10000, se hace la criba hasta 100
		int max = 100;
		cribaFactores(max);
		HashMap<Integer, Integer> fac = factorizar(895);
		System.out.println(fac.toString());
	}

	public static HashMap<Integer, Integer> factorizar(int n){
		HashMap<Integer, Integer> factores = new HashMap<Integer, Integer>();

		if(n >= menorFactor.length){
			for(int p : primos){
				if(n % p == 0){
					int count = 0;
					while(n % p == 0){
						n = n/p;
						count++;
					}
					factores.put(p, count);
				}
				if(n < menorFactor.length) break;
			}
			if(n >= menorFactor.length){
				factores.put(n, 1);
				return factores;
			}
		}

		while(n > 1){
			int f = menorFactor[n];
			if(f == -1){
				f = n;
			}
			if(factores.containsKey(f)){
				factores.put(f, factores.get(f)+1);
			}else{
				factores.put(f, 1);
			}
			n = n / f;
		}

		return factores;
	}

}
