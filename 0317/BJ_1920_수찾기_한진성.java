import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(in.readLine());

		int check[] = new int[M];
		
		st = new StringTokenizer(in.readLine());
		
		for(int i=0;i<M;i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			if(Arrays.binarySearch(arr, check[i]) < 0) {
				System.out.println(0);
			}else {
				System.out.println(1);
			}
		}
	}

}
