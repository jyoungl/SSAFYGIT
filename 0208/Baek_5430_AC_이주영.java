package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek_5430 {
	public static Deque<Integer> dq = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0; //짝수 = 정방향 (R 짝수번)
	
	public static int funcD() {
		if(dq.isEmpty()) {
			sb.append("error\n");
			return 1;
		}
		
		if(cnt%2 == 0) { //정방향
			dq.poll();
		}
		else if(cnt%2==1) { //역방향
			dq.pollLast();
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=input;tc++) {
			//수행할 함수
			char[] ch = br.readLine().toCharArray();
			//배열의 길이
			int n = Integer.parseInt(br.readLine());
			//배열 받음
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			
			for(int i=0;i<n;i++) {
				dq.add(Integer.parseInt(st.nextToken()));
			}
			
			int b = 0;
			for(int i=0;i<ch.length;i++) {
				if(ch[i] == 'R') {
					cnt++;
				}
				else if(ch[i] == 'D') {
					b += funcD();
					if(b == 1)
						break;
				}
			}			
			//출력
			if(b == 0) {
				if(dq.isEmpty()) {
					sb.append("[]\n");
					continue;
				}
				
				if(cnt%2 == 0) {
					sb.append("["+dq.poll());
					while(!dq.isEmpty()) {
						sb.append(","+dq.poll());
					}
					sb.append("]\n");
				}
				else {
					sb.append("["+dq.pollLast());
					while(!dq.isEmpty()) {
						sb.append(","+dq.pollLast());
					}
					sb.append("]\n");
				}
			}		
			cnt = 0;
			dq.clear();
		}
		System.out.println(sb);
		
	}

}
