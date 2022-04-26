import java.io.*;
import java.util.*;

//prev permutation
public class Main {
	static int[] input;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		input = new int[N];
		StringTokenizer st= new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++){
			input[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();

		if(np()){
			for(int i=0;i<N;i++){
				sb.append(input[i]).append(' ');
			}
			System.out.println(sb);
		}else{
			System.out.println(-1);
		}

	}

	private static boolean np() {
		int i=N-1;
		while(i>0 && input[i-1]<=input[i]) --i;

		if(i==0) return false;

		int j=N-1;
		while(input[i-1]<=input[j]) --j;

		swap(i-1,j);

		int k=N-1;
		while(i<k) {
			swap(i++,k--);
		}
		return true;
	}

	private static void swap(int i,int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
}
