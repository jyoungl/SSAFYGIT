package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D3_6808_규영이와인영이의카드게임 {
	static List<Integer> card1;
	static List<Integer> card2;
	static int[] nums;
	static boolean[] isSelected;
	static int win;
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input_6808.txt"));
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 순열의 문제
		// 1 ~ 18까지
		
		int T = Integer.parseInt(in.readLine());
		
		
		for(int tc=1;tc<=T;tc++) {
			card1 = new ArrayList<>();
			card2 = new ArrayList<>();
			win = 0;
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			isSelected = new boolean[9];
			nums = new int[9];
			for(int i=0;i<9;i++) {
				card1.add(Integer.parseInt(st.nextToken()));
			}

			for(int i=0;i<9;i++) {
				for(int j=1;j<=18;j++) {
					if(!card1.contains(j) && !card2.contains(j)) {
						card2.add(j);
						break;
					}
				}
			}
			
			perm(0);
			System.out.printf("#%d %d %d\n",tc,win,(362880-win));
		}
		
		
	}
	
	
	public static void perm(int cnt) {
		
		if(cnt == 9) {
			int winA = 0;
			int winB = 0;
			for(int i=0;i<9;i++) {
				int A = card1.get(i);
				int B = nums[i];
				if(A > B) {
					winA = winA + A + B;
				}else if(A<B){
					winB = winB + A + B;
				}
			}
			if(winA > winB) {
				win++;
			}
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			nums[cnt] = card2.get(i);
			perm(cnt + 1);
			isSelected[i] = false;
			
		}
		
		
	}

}
