package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
 */

public class BJ_2527_직사각형_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x1=0, x2=0, y1=0, y2=0; //첫번째 사각형
		int a1=0, a2=0, b1=0, b2=0; //두번째 사각형
		
		//4번 반복
		for(int tc=0;tc<4;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//첫번째 사각형 왼쪽아래
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			//첫번째 사각형 오른쪽위
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			//두번째 사각형 왼쪽아래
			a1 = Integer.parseInt(st.nextToken());
			b1 = Integer.parseInt(st.nextToken());
			//두번재 사각형 오른쪽위
			a2 = Integer.parseInt(st.nextToken());
			b2 = Integer.parseInt(st.nextToken());
			
			if((x2==a1 && y2==b1) || (x1==a2 && y2==b1) || (x2==a1 && y1==b2) || (x1==a2 && y1 == b2))
				sb.append("c\n");
			else if((x2==a1 && y2!=b1) || (x1==a2 && y2!=b1) || (x2!=a1 && y1==b2) || (x1!=b2 && y1==b2))
				sb.append("b\n");
			else if(x2<a1 || a2<x1 || y2<b1 || b2<y1)
				sb.append("d\n");
			else
				sb.append("a\n");
			
//			if(x2 < a1 || a2 < x1 || y2 < b1 || b2 < y1)
//				sb.append("d\n");
//			else if((x2 == a1 && y2 != b1) || (x1 == a2 && y2 != b1) || (x2 != a1 && y1 == b2) || (x1 != a2 && y1 == b2))
//				sb.append("b\n");
//			else if((x2 == a1 && y2 == b1) || (x1 == a2 && y2 == b1) || (x2 == a1 && y1 == b2) || (x1 == a2 && y1 == b2))
//				sb.append("c\n");
//			else
//				sb.append("a\n");
		}
		
		System.out.println(sb);
	}

}
