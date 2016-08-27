
public class Euclides {
	public static int mcd(int a, int b){
		while(b != 0){
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}

	//Dividir primero para evitar overflow en a*b
	public static int mcm(int a, int b){
		return a * (b / mcd(a, b));
	}
}
