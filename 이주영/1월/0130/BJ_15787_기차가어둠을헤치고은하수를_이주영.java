package jan30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_15787_기차가어둠을헤치고은하수를_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] train = new int[N+1];
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			int seat = -1;
			
			switch(op) {
			case 1:
				seat += Integer.parseInt(st.nextToken());
				train[idx] |= (1 << seat);
				// A |= (1<<K) k 원소 추가
				break;		
			case 2:
				seat += Integer.parseInt(st.nextToken());
				train[idx] &= ~(1 << seat);
				// A &= ~(1<<K) k 원소 삭제
				break;
			case 3:
				//train[idx] = (train[idx] & ~(1<<19)) << 1;
				train[idx] &= ~(1<<19);
				//20번째 원소 1이라면 삭제 (뒤로 가면 20번째 자리에 사람이 생기니까)
				train[idx] <<= 1;
				//한칸씩 이동(뒤로)
				break;
			case 4:
				//train[idx] = (train[idx] & ~(1<<0)) >> 1;
				train[idx] &= ~(1<<0);
				//첫번째 원소 삭제(앞으로 가면 하차해야 하니까)
				train[idx] >>= 1;
				//한칸씩 이동(앞으로)
				break;
			}
		}
		
		for(int i=1;i<=N;i++) {
			set.add(train[i]);
		}
		System.out.println(set.size());
	}

}
