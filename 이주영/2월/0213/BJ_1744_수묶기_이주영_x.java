package feb13;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1744_수묶기_이주영_x {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		long ans = 0;
		int x = 0;
		for(int i=N-1;i>=1;i-=2) {
			if(arr[i]>0) {
				if(arr[i-1]>0) {
					ans += Math.max(arr[i]*arr[i-1], arr[i]+arr[i-1]);
				}
				else {
					ans += arr[i];
					x = i-1;
					break;
				}
			}
			else {
				x = i;
				break;
			}
		}
		//-3 0 0 1 1 2 3  7
		if(x==0) {
			System.out.println(ans+arr[0]);
			return;
		}
		
		boolean b = false;
		if(arr[x] == 0) {
			b = true;
			x--;
		}
		
		if(x%2==0) {
			if(b)
				x--;
			for(int i=x;i>=1;i-=2) {
				ans += (arr[i]*arr[i-1]);
			}
		}
		else if(x%2==1) {
			for(int i=x;i>=1;i-=2) {
				ans += (arr[i]*arr[i-1]);
			}
		}

		System.out.println(ans);
		
	}

}
