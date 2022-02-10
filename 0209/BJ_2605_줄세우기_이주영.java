package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back_2605_줄세우기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Integer>list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=num;i++) {
			int x = Integer.parseInt(st.nextToken());
			
//			if(x == 0) {
//				list.add(i);
//			}
//			else {
				int y = list.size() - x;
				list.add(y, i);
			//}
		}

		sb.append(list.get(0));
		for(int i=1;i<num;i++) {
			sb.append(" "+list.get(i));
		}
		System.out.println(sb);
	}

}
