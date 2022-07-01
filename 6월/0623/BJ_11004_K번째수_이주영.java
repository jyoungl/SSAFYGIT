package jun23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11004_K번째수_이주영 {
	public static void quickSort(int[] arr, int L, int R) {
		int p = partition(arr, L ,R);
		
		if(L<p-1)
			quickSort(arr,L,p-1);
		
		if(p<R)
			quickSort(arr,p,R);
	}
	
	public static int partition(int[] arr, int L, int R) {
		int pivot = arr[(L+R)/2];
		
		while(L<=R) {
			while(arr[L]<pivot)L++;
			while(arr[R]>pivot)R--;
			
			if(L<=R) {
				swap(arr,L,R);
				L++;
				R--;
			}
		}
		return L;
	}
	
	public static void swap(int[] arr, int L, int R) {
		int tmp = arr[L];
		arr[L] = arr[R];
		arr[R] = tmp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(arr, 0, arr.length-1);
		
		System.out.println(arr[K-1]);
	}

}
