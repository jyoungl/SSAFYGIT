import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217_로프 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
		
		int N = Integer.parseInt(in.readLine());
		
		int arr[] = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(arr);
	
		int max = 0;
		
		for(int i=0;i<arr.length;i++) {
			
			max = Math.max(max, arr[i]*(N-i));
			
		}
		
		System.out.println(max);
	
	}

}
