package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_11866 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		Queue<Integer> que = new LinkedList<>();
		int[] res = new int[N];
		
		for(int i=1;i<=N;i++) {
			que.add(i);
		}
		
		int cnt = 0;
		sb.append("<");
		while(que.size() > 1) { //원랜 >= 1
			for(int i=0;i<K-1;i++) {
				que.offer(que.poll());
			}
			sb.append(que.poll() + ", ");		
//			if(que.size() == 1) {
//				sb.append(que.poll());
//				break;
//			}
		}
		sb.append(que.poll()+">");
		System.out.println(sb);
	}

}
