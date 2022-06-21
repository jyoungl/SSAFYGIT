package jun21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10610_30_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] N = br.readLine().toCharArray();
		int[] arr = new int[N.length];
		boolean b = false;
		int sum = 0;
		
		for(int i=0;i<N.length;i++) {
			arr[i] = N[i] - '0';
			sum += arr[i];
			if(arr[i] == 0)
				b = true;
		}
		
		if(sum%3 == 0 && b) {
			Arrays.sort(arr);
			for(int i=arr.length-1;i>=0;i--)
				sb.append(arr[i]);
		}
		else
			sb.append("-1");
		
		System.out.println(sb);
	}

}
