public class EditDistance {

	public static int editDistance(String original, String destination) {
		int sizex = destination.length();
		int sizey = original.length();
		int[][] changes = new int[sizex + 1][sizey + 1];

		for (int i = 0; i < Integer.max(sizex + 1, sizey + 1); i++) {
			if (i < sizex + 1) {
				changes[i][0] = i;
			}
			if (i < sizey + 1) {
				changes[0][i] = i;
			}
		}

		for (int i = 1; i < sizex + 1; i++) {
			for (int j = 1; j < sizey + 1; j++) {
				char x = destination.charAt(i - 1);
				char y = original.charAt(j - 1);
				if (x != y) {
					changes[i][j] = 1 + Integer.min(changes[i - 1][j], Integer.min(changes[i][j - 1], changes[i - 1][j - 1]));
				} else {
					changes[i][j] = changes[i - 1][j - 1];
				}
			}
		}

		return changes[sizex][sizey];
	}

	public static void main(String[] args) {
		String original = "icpcsucks";
		String destination = "icpcrocks";
		int changes = editDistance(original, destination);
		System.out.println(changes);
	}
}
