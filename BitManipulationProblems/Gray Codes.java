// Question : https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2114

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(st.nextToken());
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				System.out.println(k ^ (k >> 1));
			}
		}
	}
}
