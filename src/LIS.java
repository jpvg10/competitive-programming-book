import java.util.LinkedList;

public class LIS {

	public static void main(String[] args) {
		int array[] = {3, 4, -1, 0, 6, 2, 3};
		int n = array.length;

		int T[] = new int[n];
		int previous[] = new int[n];
		for(int i=0; i<n; i++){
			T[i] = 1;
			previous[i] = i;
		}

		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if(array[i] > array[j]){
					if(T[j] + 1 > T[i]){
						T[i] = T[j] + 1;
						previous[i] = j;
					}
				}
			}
		}

		int maxIndex = 0;
		for(int i=0; i<n; i++){
			if(T[i] > T[maxIndex]){
				maxIndex = i;
			}
		}

		//Longitud de la LIS
		int lisLength = T[maxIndex];

		//La subsecuencia como tal
		int t = maxIndex;
		int newT = maxIndex;
		LinkedList<Integer> subsequence = new LinkedList<Integer>();
		do{
			t = newT;
			subsequence.addFirst(array[t]);
			newT = previous[t];
		}while(t != newT);
	}
}
