package 기타;

import java.io.*;
import java.util.*;

public class BJ_11656_접미사배열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		
		// 디폴트: 오름차순
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		for (int i = 0; i < s.length(); i++) {
			// substring(시작하는문자열의인덱스:0번부터시작)
			pq.add(s.substring(i));
		}
		for (int i = 0; i < s.length(); i++) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb);
	}

}
