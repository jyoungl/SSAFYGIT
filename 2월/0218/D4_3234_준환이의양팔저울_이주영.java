import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_3234_준환이의양팔저울_이주영 {
	static int T;
	static int N;
	static int[] arr, arr2;
	static boolean[] check;
	static int res;
	
	static void func2(int cnt, int L, int R) {
		if(cnt == N) {
			res++;
			return;
		}
		
		func2(cnt+1, L+arr2[cnt], R);
		
		if(R + arr2[cnt] <= L)
			func2(cnt+1, L, R+arr2[cnt]);
	}
	
	static void func(int cnt) {
		if(cnt == N) {
			func2(0, 0, 0);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(check[i])
				continue;
			check[i] = true;
			arr2[cnt] = arr[i];
			func(cnt+1);
			check[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			String[] str = br.readLine().split(" ");
			for(int i=0;i<N;i++)
				arr[i] = Integer.parseInt(str[i]);
		
			arr2 = new int[N];
			check = new boolean[N];
			res = 0;
			func(0);
			
			sb.append("#"+tc+" "+res+"\n");
		}
		
		System.out.println(sb);
	}

}
