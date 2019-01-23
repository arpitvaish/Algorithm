import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	public static int[][] arr = new int[205][25];

	public static Integer maxRev(int M, int[][] choice, int C, int R, int N) {

		if (C > N) {
			return 0;
		}

		if (M < 0) {
			return Integer.MIN_VALUE;
		}

		if (arr[M][C] != -1) {
			return arr[M][C];
		}
		R = Integer.MIN_VALUE;
		for (int i = 0; i < choice[C].length; i++) {
			if (M < choice[C][i]) {
				continue;
			}
			int n = M - choice[C][i];
			R = Math.max(R, choice[C][i] + maxRev(n, choice, C + 1, R, N));
			arr[M][C] = R;
		}
		return R;

	}

	public static void main(String args[]) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			st = new StringTokenizer(reader.readLine());
			int T = Integer.parseInt(st.nextToken());
			for (int i = 0; i < T; i++) {

				for (int k = 0; k < 205; k++) {
					Arrays.fill(arr[k], -1);
				}

				st = new StringTokenizer(reader.readLine());
				int M = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int[][] choice = new int[C][];
				for (int j = 0; j < C; j++) {
					st = new StringTokenizer(reader.readLine());
					int numOfModel = Integer.parseInt(st.nextToken());
					int choices[] = new int[numOfModel];
					for (int k = 0; k < numOfModel; k++) {
						choices[k] = Integer.parseInt(st.nextToken());
					}
					choice[j] = choices;
				}
				int totalRev = maxRev(M, choice, 0, 0, C - 1);
				if (totalRev < 0) {
					System.out.println("no solution");
				} else {
					System.out.println(totalRev);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
