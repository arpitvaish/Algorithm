import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			st = new StringTokenizer(reader.readLine());
			int t = Integer.parseInt(st.nextToken());

			while (t-- > 0) {
				st = new StringTokenizer(reader.readLine());
				int N = Integer.parseInt(st.nextToken());
				int n = 1 << N, count = 0;
				int m = Integer.parseInt(st.nextToken());
				int[] a = new int[n];
				Arrays.fill(a, 1);
				st = new StringTokenizer(reader.readLine());
				for (int i = 0; i < m; i++) {
					a[Integer.parseInt(st.nextToken()) - 1] = 0;
				}

				while (n > 1) {
					int temp[] = new int[n >> 1];
					for (int i = 0; i < n; i += 2) {
						if ((a[i] ^ a[i + 1]) == 1) {
							count++;
						}
						temp[i / 2] = a[i] | a[i + 1];

					}
					n >>= 1;
					a = temp;
				}
				System.out.println(count);

			}
		} catch (Exception ex) {

		}
	}

}
