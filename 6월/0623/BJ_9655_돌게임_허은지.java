package 문제풀이;

import java.io.*;
import java.util.*;

public class S5_9655_돌게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		if(N%2 == 1) System.out.println("SK");
		else System.out.println("CY");

	}

}
