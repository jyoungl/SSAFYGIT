package feb14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1715_카드정렬하기_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>();
		
		//1 2 3 4 5
		//3 3 4 5 -> (1+2)
		//6 4 5 -> (3+3)
		//6 9 -> (4+5)
		//15+9+6+3=33
		for(int i=0;i<N;i++) {
			que.add(Integer.parseInt(br.readLine()));
		}
		int ans = 0;
		while(que.size()>=2) {
			int x = que.poll();
			int y = que.poll();
			ans += x + y;
			que.add(x+y);
		}
		System.out.println(ans);
	}

}
