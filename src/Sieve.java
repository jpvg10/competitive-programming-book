import java.util.ArrayList;
import java.util.HashMap;

public class Sieve {
	
	public static ArrayList<Integer> sieve(int n){
		boolean marked[] = new boolean[n+1];
		marked[0] = true;
		marked[1] = true;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for(int i=2; i<=n; i++){
			if(!marked[i]){
				primes.add(i);
				//OJO: Si esta teniendo problemas de overflow, cambie la siguiente linea por j = 2*i. Si sigue teniendo problemas, probablemente necesite una Criba Segmentada
				int j = i*i;
				while(j <= n){
					marked[j] = true;
					j = j+i;
				}
			}
		}
		
		return primes;
	}
	
	//Usa el metodo sieve()
	public static HashMap<Integer, Integer> factor(int n){
		HashMap<Integer, Integer> primeFactors = new HashMap<Integer, Integer>();		
		int s = (int) Math.ceil(Math.sqrt(n));
		ArrayList<Integer> primes = sieve(s);
		
		for(int p: primes){
			while(n % p == 0){
				n = n/p;
				if(primeFactors.containsKey(p)){
					primeFactors.put(p, primeFactors.get(p)+1);
				}else{
					primeFactors.put(p, 1);
				}
			}
		}
		
		if(n > 1){
			primeFactors.put(n, 1);
		}
		
		return primeFactors;
	}
}
