package dec09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1783_병든나이트_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //세로
		int M = Integer.parseInt(st.nextToken()); //가로
		int res = 0;
		
		if(N == 2) {
			res = (M-1)/2;
			res = (res > 3 ? 3:res);
		}
		else if(M<7) {
			res = M-1;
			res = (res>3?3:res);
		}
		else if(N==1) {}
		else
			res = 4 + M - 7;
		System.out.println(res+1);
		
	}

}
