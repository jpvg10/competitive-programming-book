import java.util.Arrays;

public class CoinChange {

	static int result;
	static int[] coinsResult;

	public static void coinChange(int sum, int[] denomination) {
		int size = denomination.length;

		int[] minimal = new int[sum + 1];
		int[] coins = new int[sum + 1];

		Arrays.fill(minimal, Integer.MAX_VALUE);
		Arrays.fill(coins, -1);
		minimal[0] = 0;

		for (int i = 0; i < size; i++) {
			int coin = denomination[i];
			for (int j = coin; j < sum + 1; j++) {
				if (minimal[j - coin] != Integer.MAX_VALUE) {
					int choose = Integer.min(minimal[j], minimal[j - coin] + 1);
					if (choose < minimal[j]) {
						minimal[j] = choose;
						coins[j] = coin;
					}
				}
			}
		}

		if(minimal[sum] == Integer.MAX_VALUE) {
			result = -1;
		}else {
			result = minimal[sum];

			// Si se quiere hallar exactamente cuales monedas se escogieron
			coinsResult = new int[result];
			int pointer = sum;
			for (int i = 0; i < result; i++) {
				coinsResult[i] = coins[pointer];
				pointer = pointer - coins[pointer];
			}
		}
	}

	public static void main(String[] args) {
		int sum = 800;
		int[] denominations = { 100, 200, 500 };
		coinChange(sum, denominations);
		if(result == -1) {
			// No es posible
		}else {
			System.out.println(result);
			for(int c : coinsResult) {
				System.out.println(c);
			}
		}
	}
}
