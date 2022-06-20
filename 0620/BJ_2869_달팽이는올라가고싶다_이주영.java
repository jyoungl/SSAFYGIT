package jun20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2869_달팽이는올라가고싶다_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long V = Integer.parseInt(st.nextToken());
		
		long t = V - A;
		long y = A - B;
		
		if(t==0) {
			System.out.println(1);
			return;
		}
		long x = (t%y>=1 ? t/y+1 : t/y);
		System.out.println(x+1);
	}

}
