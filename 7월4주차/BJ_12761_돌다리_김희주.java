import java.io.*;
import java.util.*;

public class BOJ_12761_돌다리 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] count = new int[100001];
		count[N] = 1;

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(N);
		int now;

		int[] delta;
		while(!queue.isEmpty()){
			now = queue.poll();

			delta = new int[]{1,-1,A,-A,B,-B,A,B};

			for(int d=0;d<8;d++){
				int tmp = now+delta[d];
				if(d>=6) tmp = now*delta[d];
				if(tmp>=0 && tmp<=100000 && count[tmp]==0){
					count[tmp] = count[now]+1;
					queue.offer(tmp);
				}
			}
		}

		System.out.println(count[M]-1);
	}
}
