import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st= new StringTokenizer(in.readLine());

		int arr1[] = new int[N];
		
		for(int i=0;i<N;i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(in.readLine());
		
		int[] arr2 = new int[M];
		
		st= new StringTokenizer(in.readLine());
		
		int[] ans = new int[M];
		for(int i=0;i<M;i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);
		for(int i=0;i<M;i++) {
			if(Arrays.binarySearch(arr1, arr2[i]) >= 0) {
				ans[i] = 1;
			}
		}
		
		for(int i=0;i<M;i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
