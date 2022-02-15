package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 입력 1+H행
 * 1. 정수 세로 H 가로 W
 * 2. 구름 C 구름 없으면 .
 * 출력
 * 구름 안 오면 -1
 * 구름 떠 있었으면 0
 * 구름이 올 시간
 */
public class s5_10709_기상캐스터 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < H; i++) {
			int count = 0;
			boolean isCloud = false;
			
			String w = br.readLine();
			for(int j = 0; j<W; j++) {
				char cloud = w.charAt(j);
				
				if(!isCloud && cloud=='.') sb.append(-1).append(" ");
				else if(cloud == 'c') {
					sb.append(0).append(" ");
					count = 0;
					isCloud = true;
				}
				else if(isCloud && cloud=='.') {
					sb.append(++count).append(" ");
				}
			}
			
			sb.append("\n");
		
		}
		
		System.out.println(sb);
		
	}
}
