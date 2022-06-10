import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1183_약속 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		
		int arr[] = new int[N];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			
			arr[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
			
			
		}
		
		Arrays.sort(arr);
	
		if(N % 2 != 0) {
			System.out.println(1);
		}else {
			System.out.println(Math.abs(arr[N/2] - arr[N/2-1])+1);
		}
		

	}

}
