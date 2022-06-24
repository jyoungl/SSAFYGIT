package 기타;

import java.io.*;
import java.util.*;

public class BJ_9655_돌게임 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		// 두 사람이 완벽하게 게임을 했을 때 : 본인이 이기도록
		if (N % 4 == 1 || N % 4 == 3) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}

}
