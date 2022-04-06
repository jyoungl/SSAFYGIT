import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int dir[] = {1,-1};
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(in.readLine());
		
		st = new StringTokenizer(in.readLine()," ");
		
		int[] arr2 = new int[M];
		
		for(int i=0;i<M;i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		StringBuilder sb= new StringBuilder();
		
		for(int i=0;i<M;i++) {
			int A = 0;
			int B = 0;
			int low = 0;
			int high = arr.length;
			while(low < high) {
				int mid = (low + high)/2;
				if(arr2[i] <= arr[mid]) {
					high = mid;
				}else {
					low = mid+1;
				}
			}
			A = low;
			low = 0;
			high = arr.length;
			while(low < high) {
				int mid = (low + high)/2;
				if(arr2[i] < arr[mid]) {
					high = mid;
				}else {
					low = mid+1;
				}
			}
			B = low;
			
			sb.append(B-A).append(' ');
		}
		
		sb.setLength(sb.length()-1);
		
		System.out.println(sb);
	}
}