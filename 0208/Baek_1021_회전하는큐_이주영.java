package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
//import java.util.ArrayDeque;
//import java.util.Deque;
import java.util.StringTokenizer;

public class Baek_1021 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		LinkedList<Integer> deque = new LinkedList<Integer>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			deque.add(i);
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<M;i++) {
			int target = Integer.parseInt(st.nextToken());
			
			while(true) {
				if(deque.peek() == target) {
					deque.poll();
					break;
				}

				if(deque.indexOf(target) <= deque.size()/2) {
					deque.addLast(deque.poll());
				}
				else {
					deque.add(deque.pollLast());
				}

				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
