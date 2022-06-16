import java.io.*;
import java.util.*;

public class BOJ_2217_로프 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] input = new int[N];
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(in.readLine());
		Arrays.sort(input);

		int max = input[0]*N;
		for(int i=1;i<N;i++){
			if(max<input[i]*(N-i)){
				max = input[i]*(N-i);
			}
		}
		System.out.println(max);

	}
}
