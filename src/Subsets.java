import java.util.ArrayList;

public class Subsets {

	public static void main(String[] args) {
		String elements[] = {"A", "B", "C", "D"};
		int n = elements.length;

		for(int b=0; b < (1 << n); b++){
			ArrayList<String> subset = new ArrayList<String>();
			for(int i=0; i<n; i++){
				if((b & (1 << i)) != 0){
					subset.add(elements[i]);
				}
			}
			System.out.println(subset.toString());
		}
	}

}
