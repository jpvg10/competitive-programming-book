import java.util.Arrays;

public class Combinations {

	static String elements[];
	static String result[];

	public static void main(String[] args) {
		int n = 5;
		int k = 3;
		elements = new String[n];
		result = new String[k];

		elements[0] = "A";
		elements[1] = "B";
		elements[2] = "C";
		elements[3] = "D";
		elements[4] = "E";

		generateCombinations(k, 0);
	}

	public static void generateCombinations(int len, int startPosition){
		int n = elements.length;
		int k = result.length;
		if(len == 0){
			System.out.println(Arrays.toString(result));
		}else{
			for(int i=startPosition; i<=n-len; i++){
				result[k - len] = elements[i];
				generateCombinations(len-1, i+1);
			}
		}
	}

}
