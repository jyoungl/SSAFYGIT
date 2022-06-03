package 문제풀이;

import java.io.*;
import java.util.*;

public class S2_1058_친구 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		char[][] friend = new char[N][N];
		boolean[][] isFriend = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				friend[i][j] = str.charAt(j);
			}
		}

		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			int twoFriend = 0;
			for (int j = 0; j < N; j++) {
				if(friend[i][j]=='Y') {
					isFriend[i][j] = true;
					for (int k = 0; k < N; k++) {
						if(friend[j][k]=='Y') isFriend[i][k] = true;
					}
				}
			}
			
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				if(isFriend[i][j]) twoFriend++;
			}
			 
			max = Math.max(max, twoFriend);
		}
		
		System.out.println(max);

	}

}
