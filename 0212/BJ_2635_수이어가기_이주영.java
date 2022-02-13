package bqj;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_2635_수이어가기_이주영 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> maxlist = new ArrayList<>();
		
		int N = in.nextInt();
		int max = 0;
		
		for(int i=N;i>=1;i--) {
			ArrayList<Integer> list = new ArrayList<>();
		
			list.add(N);
			list.add(i);
			
			int prev = N;
			int res = i;
			while(true) {
				int y = prev - res; //두번째 - 세번째
				if(y < 0)
					break;				
				//else
				list.add(y);
				prev = res; // 두번째수
				res = y;			
			}

			if(max < list.size()) {
				max = list.size();
				maxlist = list;
			}
			
		}
		
		sb.append(max+"\n");
		for(int i=0;i<maxlist.size();i++) {
			sb.append(maxlist.get(i)+" ");
		}
		
		System.out.println(sb);
		
	}

}
