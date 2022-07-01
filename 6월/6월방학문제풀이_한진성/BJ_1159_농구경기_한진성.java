import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1159_농구경기 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] arr = new int[200];
		
		
		
		for(int i=0;i<N;i++) {
			arr[in.readLine().charAt(0)]++; 
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<200;i++) {
			if(arr[i] >= 5) {
				sb.append((char)i);
			}
		}
		if(sb.length() == 0) {
			System.out.println("PREDAJA");
		}else {
			System.out.println(sb);
		}

	}

}
