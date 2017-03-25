
public class LCS {

	public static void main(String[] args) {
		String str1 = "ABCDGHLQR";
		String str2 = "AEDPHR";

		char x[] = str1.toCharArray();
		char y[] = str2.toCharArray();
		int T[][] = new int[x.length + 1][y.length + 1];

		for(int i=1; i<=x.length; i++){
			for(int j=1; j<=y.length; j++){
				if(x[i-1] == y[j-1]){
					T[i][j] = T[i-1][j-1] + 1;
				}else{
					T[i][j] = Math.max(T[i][j-1], T[i-1][j]);
				}
			}
		}

		//Longitud de la LCS
		int lcsLength = T[x.length][y.length];

		//La LCS como tal
		int i = x.length;
		int j = y.length;
		StringBuilder sb = new StringBuilder();
		while(i > 0 && j > 0){
			if(T[i][j] == T[i-1][j]){
				i--;
			}else if(T[i][j] == T[i][j-1]){
				j--;
			}else{
				sb.append(x[i-1]);
				i--;
				j--;
			}
		}
		String lcs = sb.reverse().toString();
	}

}
