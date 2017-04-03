import java.util.ArrayList;
import java.util.HashMap;

public class Sieve {
	
	public static ArrayList<Integer> criba(int n){
		boolean marked[] = new boolean[n+1];
		marked[0] = true;
		marked[1] = true;
		ArrayList<Integer> primos = new ArrayList<Integer>();
		
		for(int i=2; i<=n; i++){
			if(!marked[i]){
				primos.add(i);
				//OJO: Si esta teniendo problemas de overflow, cambie la siguiente linea por j = 2*i
				int j = i*i;
				while(j <= n){
					marked[j] = true;
					j = j+i;
				}
			}
		}
		
		return primos;
	}
	
}
