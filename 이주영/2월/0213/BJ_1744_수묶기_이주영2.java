package feb13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1744_수묶기_이주영2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int posNum = 0;
		int negNum = 0;
		boolean zero = false;
		long ans = 0;
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(br.readLine());
			arr[i] = x;
			if(x>0)
				posNum++;
			else if(x==0)
				zero = true;
			else
				negNum++;
		}
		Arrays.sort(arr);
		int e = 0;
		if(posNum%2==0) {
			int idx = N-1;
			for(int i=0;i<posNum/2;i++) {
				ans += Math.max(arr[idx]*arr[idx-1],arr[idx]+arr[idx-1]);
				idx -= 2;
			}
		}
		else if(posNum%2==1) {
			if(posNum==1)
				e = arr[N-1];
			else {
				int idx = N-1;
				for(int i=0;i<posNum/2;i++) {
					ans += Math.max(arr[idx]*arr[idx-1],arr[idx]+arr[idx-1]);
					idx -= 2;
				}
				e = arr[idx];
			}
		}
		
		if(negNum%2==0) {
			for(int i=0;i<negNum;i+=2) {
				ans += Math.max(arr[i]*arr[i+1],arr[i]+arr[i+1]);
			}
			ans += e;
		}
		else if(negNum%2==1) {
			for(int i=0;i<negNum-1;i+=2) {
				ans += Math.max(arr[i]*arr[i+1],arr[i]+arr[i+1]);
			}
			if(zero) {
				ans += e;
			}
			else {
				if(posNum%2==1)
					ans += Math.max(arr[negNum-1]*e, arr[negNum-1]+e);
				else
					ans += arr[negNum-1];
			}
		}
		System.out.println(ans);
	}

}
