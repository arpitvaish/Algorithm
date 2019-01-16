import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	 public static boolean isNeibhour(int i, int j){
	        int n = i^j;
	        return (n&(-n)) == n;
	    }

	    public static int setIBit(int n, int i){
	        return n ^ (1 << i);
	    }
	    public static void main(String args[]) {

	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = null;

	        try {
	        	st = new StringTokenizer(reader.readLine());
	            int N = Integer.parseInt(st.nextToken());
	            int potency[] = new int[1<<N];
	            int weights[] = new int[1<<N];
	            for(int i=0;i<1<<N;i++){
	            	st = new StringTokenizer(reader.readLine());
	                weights[i] = Integer.parseInt(st.nextToken());
	            }

	            for(int i=0; i< 1<<N; i++){
	                for(int j = 0;j < N;j++){
	                    potency[i] += weights[setIBit(i,j)];
	                }
	            }

	            int max = Integer.MIN_VALUE;
	            for(int i=0;i< 1<<N;i++){
	                for(int j=0;j< 1<< N; j++){
	                    if(! isNeibhour(i,j) || i==j)
	                        continue;
	                    max = Math.max(max, potency[i]+potency[j]);
	                }
	            }
	            System.out.println(max);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }



	    }


}
