import java.util.ArrayList;

public class GeneratePrimes {
	
	static ArrayList<Integer> primes;
		
	public static void generatePrimes(int n){
		primes = new ArrayList<Integer>();
		primes.add(2);
		int x = 3;
		
		while(primes.size() < n){			
			if(isPrime(x)){
				primes.add(x);				
			}
			x = x+2;
		}
	}
	
	private static boolean isPrime(int x){
		int s = (int) Math.ceil(Math.sqrt(x));
		boolean prime = true;		
		
		for(int p: primes){
			if(p > s) break;
			if(x % p == 0){
				prime = false;
				break;
			}		
		}
		
		return prime;
	}

}
