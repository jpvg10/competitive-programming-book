import java.util.Arrays;

public class BusquedaBinaria {

	public static void main(String[] args) {
		int[] array = new int[5];		
		int index = Arrays.binarySearch(array, 10);
		if(index >= 0) {
			// El elemento esta en el array, en la posicion index
		}else {
			// El elemento no esta en el array
			// Si estuviera, seria en la siguiente posicion:
			index = -1*(index+1);
		}
	}
}
