package jun30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class BJ_2822_점수계산_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[8][2];
		
		for(int i=0;i<8;i++) {
			arr[i][0] = Integer.parseInt(br.readLine());
			arr[i][1] = i+1;
		}
		
		Arrays.sort(arr, (int[] o1, int[] o2)->{
			return o2[0] - o1[0];
		});
		
		int sum = 0;
		int[] res = new int[5];
		
		for(int i=0;i<5;i++) {
			sum += arr[i][0];
			res[i] = arr[i][1];
		}
		Arrays.sort(res);
		
		System.out.println(sum);
		for(int i=0;i<5;i++)
			System.out.print(res[i] + " ");
	}

}
