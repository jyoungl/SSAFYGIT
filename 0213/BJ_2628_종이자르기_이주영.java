package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_2628_종이자르기_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken()); //가로
		int h = Integer.parseInt(st.nextToken()); //세로
		
		int N = Integer.parseInt(br.readLine()); //자르는 점선 개수

		LinkedList<Integer> listw = new LinkedList<Integer>();
		LinkedList<Integer> listh = new LinkedList<Integer>();
		
		//점선 개수만큼 반복문
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()); //가로,세로 구분
			int num = Integer.parseInt(st.nextToken()); //점선 번호
			
			if(dir == 0) { //가로일 때
				listw.add(num);
			}
			else {
				listh.add(num);
			}
		}
		
		listw.add(0);
		listw.add(h);
		listh.add(0);
		listh.add(w);
		
		listw.sort(null);
		listh.sort(null);
		
		//계산
		int max1=0; int max2=0;
		for(int i=1;i<listw.size();i++) {
			int x = listw.get(i) - listw.get(i-1);
			if(max1 < x)
				max1 = x;
		}
		for(int i=1;i<listh.size();i++) {
			int y = listh.get(i) - listh.get(i-1);
			if(max2 < y)
				max2 = y;
		}
		
		System.out.println(max1*max2);
	}

}
