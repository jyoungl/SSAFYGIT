package jun16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1476_날짜계산_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int year = 1;
		int e1=1,s1=1,m1=1;
		
		while(true) {
			if(E == e1 && S == s1 && M == m1)
				break;
			
			year++;
			e1++; s1++; m1++;
			if(e1 == 16)
				e1 = 1;
			if(s1 == 29)
				s1 = 1;
			if(m1 == 20)
				m1 = 1;
		}
		
		System.out.println(year);
	}

}
