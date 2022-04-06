package im형필수문제;

import java.util.*;
import java.io.*;

public class s5_2947_나무조각 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[5];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int tmp;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 1 ; j < arr.length - i; j++) {
				if(arr[j]<arr[j-1]) {
					tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
					for(int k = 0; k<5; k++) {
						System.out.print(arr[k] + " ");
					}
					System.out.println();
				}
			}	
		}	
	}
}
