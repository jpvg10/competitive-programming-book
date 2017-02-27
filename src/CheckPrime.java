import java.math.BigInteger;

public class CheckPrime {
		
	public static boolean isPrime(int x){
		if(x == 1) return false;
		if(x == 2) return true;
		if(x % 2 == 0) return false;
		
		int s = (int) Math.ceil(Math.sqrt(x));
		
		for(int i=3; i<=s; i+=2){
			if(x % i == 0) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		isPrime(63); //true
		isPrime(99); //false
		
		//De hecho estos si caben en un int pero los pongo como ejemplo
		BigInteger a = new BigInteger("104723");
		BigInteger b = new BigInteger("104727");
		a.isProbablePrime(10); //true
		b.isProbablePrime(10); //false
	}
}
