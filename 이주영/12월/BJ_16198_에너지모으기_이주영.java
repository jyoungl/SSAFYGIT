package dec31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16198_에너지모으기_이주영 {
	static int[] energy;
	static boolean[] visited;
	static int N;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		energy = new int[N];
		
		for(int i=0;i<N;i++)
			energy[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<N-1;i++) {
			visited= new boolean[N];
			visited[i] = true;
			int e = energy[i-1] * energy[i+1];
			charge(1, e);
		}
		
		System.out.println(max);
	}

	public static void charge(int cnt, int sum) {
		if(cnt == N-2) {
			max = (max<sum ? sum: max);
			return;
		}
		
		for(int i=1;i<N-1;i++) {
			if(!visited[i]) {
				visited[i] = true;
				int lefte = 0;
				int righte = 0;
				for(int j=i-1;j>=0;j--) {
					if(!visited[j]) {
						lefte = energy[j];
						break;
					}
				}
				for(int j=i+1;j<N;j++) {
					if(!visited[j]) {
						righte = energy[j];
						break;
					}
				}
				charge(cnt+1, sum+(lefte * righte));
				visited[i] = false;
			}
		}
	}
}
