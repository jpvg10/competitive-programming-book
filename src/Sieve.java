import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Sieve {
	
	public static ArrayList<Integer> sieve(int n){
		boolean marked[] = new boolean[n+1];		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for(int i=2; i<=n; i++){
			if(!marked[i]){
				primes.add(i);
				int j = 2*i;
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
		ArrayList<Integer> primes = sieve(n);
		HashMap<Integer, Integer> primeFactors = new HashMap<Integer, Integer>();
		
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
		
		return primeFactors;
	}
	
	//Usa el metodo factor(), que a su vez usa a sieve()
	public static int divisors(int n){
		int div = 1;
		HashMap<Integer, Integer> primeFactors = factor(n);
		
		for(Entry<Integer, Integer> e: primeFactors.entrySet()){
			div = div * (e.getValue() + 1);
		}
		
		return div;		
	}
}
