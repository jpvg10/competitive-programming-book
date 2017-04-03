import java.util.LinkedList;

public class Permutations {

	static String elements[];
	static boolean p[];
	static LinkedList<String> permutation;

	public static void main(String[] args) {
		int n = 3;
		elements = new String[n];
		p = new boolean[n];
		permutation = new LinkedList<String>();

		elements[0] = "A";
		elements[1] = "B";
		elements[2] = "C";

		generatePermutations();
	}

	public static void generatePermutations(){
		int n = elements.length;
		if(permutation.size() == n){
			System.out.println(permutation.toString());
		}else{
			for(int i=0; i<n; i++){
				if(!p[i]){
					p[i] = true;
					permutation.addLast(elements[i]);
					generatePermutations();
					p[i] = false;
					permutation.pollLast();
				}
			}
		}
	}

}
