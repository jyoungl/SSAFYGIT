package 기타;

import java.io.*;
import java.util.*;

public class BJ_3036_링 {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		StringBuilder sb =new StringBuilder();
		int ring = in.nextInt();
		int[] r = new int[ring+1];
		for (int i = 1; i <=ring; i++) {
			r[i]=in.nextInt();
		}
		for (int i = 1; i <= ring-1; i++) {
			int gcd = getGCD(r[1], r[i+1]);
			sb.append(r[1]/gcd+"/"+r[i+1]/gcd).append("\n");
		}
		System.out.println(sb);
	}

	private static int getGCD(int num1, int num2) {
		if (num1 % num2 == 0) {
            return num2;
        }
		return getGCD(num2, num1%num2);
	}

}
