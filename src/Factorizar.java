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
		//Por ejemplo, si el mayor valor posible es 10^14, se hace la criba hasta 10^7
		int max = 10000000;
		cribaFactores(max);
		HashMap<Long, Integer> fac = factorizar(100000000000000L);
		System.out.println(fac.toString());
	}

	public static HashMap<Long, Integer> factorizar(long n){
		HashMap<Long, Integer> factores = new HashMap<Long, Integer>();		
				
		if(n >= menorFactor.length){			
			for(int p : primos){
				if(n % p == 0){
					int count = 0;
					while(n % p == 0){
						n = n/p;
						count++;
					}
					factores.put((long)p, count);
				}
				if(n < menorFactor.length) break;
			}
			if(n >= menorFactor.length){
				factores.put(n, 1);
				return factores;
			}			
		}
		
		int m = (int) n;
				
		while(m > 1){
			int f = menorFactor[m];
			if(f == -1){
				f = m;
			}
			if(factores.containsKey((long)f)){
				factores.put((long)f, factores.get((long)f)+1);
			}else{
				factores.put((long)f, 1);
			}
			m = m / f;
		}		
		
		return factores;
	}

}
