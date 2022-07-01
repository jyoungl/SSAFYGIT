package 기타;

import java.io.*;
import java.util.*;

public class BJ_2693_N번째큰수 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			arr = new int[10];
			for (int j = 0; j < 10; j++) {
				arr[j] = in.nextInt();				
			}
			Arrays.sort(arr);
			System.out.println(arr[7]);
		}
	}

}
