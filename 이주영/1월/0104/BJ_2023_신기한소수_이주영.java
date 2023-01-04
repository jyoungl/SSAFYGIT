package jan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_2023_신기한소수_이주영 {
	public static int N, M;
	public static int[] decimal = {1,2,3,5,7,9};
	public static ArrayList<Integer> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = 6;
		ans = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<M;i++)
			check(0,String.valueOf(decimal[i]));
		
		Collections.sort(ans);
		for(int i=0;i<ans.size();i++)
			sb.append(ans.get(i)).append("\n");
		
		System.out.println(sb);
	}
	
	public static void check(int cnt, String s) {
		if(cnt == N-1) {
			int x = Integer.parseInt(s);
			if(prime(x)) {
				ans.add(x);
			}		
			return;
		}
		
		for(int i=0;i<M;i++) {
			if(prime(Integer.parseInt(s)))
				check(cnt+1,s+String.valueOf(decimal[i]));
		}
	}

	public static boolean prime(int num) {
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i == 0)
				return false;
		}
		
		return true;
	}
}
