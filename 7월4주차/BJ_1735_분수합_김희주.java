import java.io.*;
import java.util.*;

public class BOJ_1735_분수합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int b1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int a2 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());

		int A = a1*b2+a2*b1;
		int B = b1*b2;

		int g = gcd(A,B);

		System.out.println(A/g+" "+B/g);
	}
	private static int gcd(int a, int b){
		if(a<b){
			int tmp = a;
			a = b;
			b = tmp;
		}

		if(a%b==0) return b;
		return gcd(b,a%b);
	}

}
