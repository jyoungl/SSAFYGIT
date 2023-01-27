package jan27;

import java.util.Scanner;

public class BJ_1094_막대기_이주영 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int X = in.nextInt();
		int sum = 64;
		int cnt = 0;
		
		while(X > 0) {
			if(sum>X)
				sum /= 2;
			else {
				cnt++;
				X -= sum;
			}
		}
		System.out.println(cnt);
	}

}
