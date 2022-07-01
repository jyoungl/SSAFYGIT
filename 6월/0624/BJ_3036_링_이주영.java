package jun24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3036_링_이주영 {
	public static int func(int x, int y) {
		if(y>x) {
			int t = x;
			x = y;
			y = t;
		}
		
		for(int i=y;i>1;i--) {
			if(x%i == 0 && y%i == 0)
				return i;
		}
		return 1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[]arr = new int[N];
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<N;i++) {
			int res = func(arr[0], arr[i]);
			System.out.println(arr[0]/res + "/" + arr[i]/res);
		}
	}

}
