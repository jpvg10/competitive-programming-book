public class SparseTable {

	static int[][] sparseTable;

	// Metodo para armar la sparseTable, recibe el array de entrada y no retorna nada
	// Notese que la sparseTable se tiene como variable global
	public static void buildTable(int[] array) {
		int len = array.length;
		int log = log2(len);
		sparseTable = new int[len][log + 1];
		for (int i = 0; i < len; i++) {
			sparseTable[i][0] = i;
		}

		for (int i = 1; i < log + 1; i++) {
			int k = (int) Math.pow(2, i);
			for (int j = 0; j + k - 1 < len; j++) {
				int left = sparseTable[j][i - 1];
				int right = sparseTable[j + i][i - 1];
				sparseTable[j][i] = array[left] < array[right] ? left : right;
			}
		}
	}

	// Hace la busqueda en el sparseTable
	public static int query(int inf, int sup, int[] array) {
		int l = sup - inf + 1;
		int k = log2(l);
		int left = array[sparseTable[inf][k]];
		l = l - (int) Math.pow(2, k);
		inf = inf + l;
		int right = array[sparseTable[inf][k]];
		return Math.min(left, right);
	}

	// Metodo que retorna el logaritmo base 2 de un numero
	public static int log2(int n) {
		return 31 - Integer.numberOfLeadingZeros(n);
	}

	public static void main(String[] args) {
		int[] array = { 4, 6, 1, 5, 7, 3 };
		buildTable(array); // Metodo para armar la sparseTable
		int inf = 0; // Limite inferior del query
		int sup = 3; // Limite superior del query
		int min = query(inf, sup, array); // Metodo para hallar el valor minimo en un rango
		System.out.println(min);
	}
}
