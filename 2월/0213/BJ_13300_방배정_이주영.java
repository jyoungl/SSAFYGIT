package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13300_방배정_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] wstud = new int[7]; //인덱스: 학년
		int[] mstud = new int[7];
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int room = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			if(S == 1)
				wstud[Y] += 1;
			else
				mstud[Y] += 1;
		}
		
		for(int i=1;i<=6;i++) {
			int x = wstud[i];
			if(x%K == 0)
				room += (x/K);
			else
				room += (x/K + 1);
			
			int y = mstud[i];
			if(y%K == 0)
				room += (y/K);
			else
				room += (y/K + 1);
		}
		
		System.out.println(room);
	}

}
