import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (;;) {
			try {

				st = new StringTokenizer(reader.readLine());
				long N = Long.parseLong(st.nextToken());
				int a = 0, b = 0, flag = 0, i = 0;
				if (N == 0) {
					return;
				}

				while (N > 0) {
					if ((N & 1L) == 1) {
						if (flag == 0) {
							a |= (1L << i);
							flag = 1;
						} else {
							b |= (1L << i);
							flag = 0;
						}

					}
					i++;
					N >>= 1;
				}

				System.out.println(a + " " + b);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
