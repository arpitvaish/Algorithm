
public class Solution {

	public static void main(String[] args) {
		String text = "abcabdabc";
		String pattern = "abc";
		int[] z = zAlgorithm(text, pattern);
		System.out.println(z);
	}

	public static int[] zAlgorithm(String text, String pattern) {
		int z[] = new int[text.length() + pattern.length() + 1];
		char[] S = (pattern + "$" + text).toCharArray();
		int L = 0, R = 0, n = z.length;
		for (int i = 1; i < n; i++) {

			if (i > R) {
				L = R = i;
				while (R < n && S[R] == S[R - L]) {
					R++;
				}

				z[i] = R - L;
				R--;

			} else {
				int k = i - L;
				if (z[k] < R - i + 1) {
					z[i] = z[k];
				} else {
					L = i;
					while (R < n && S[R] == S[R - L]) {
						R++;
					}

					z[i] = R - L;
					R--;
				}
			}

		}
		return z;
	}

}
