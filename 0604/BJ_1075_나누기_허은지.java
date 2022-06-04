package 문제풀이;

import java.io.*;
import java.util.*;

public class B5_1075_나누기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());

		int num = N/100*100;
		
		if(num%F==0) num = num/F*F%100;
		else num = (num/F+1)*F%100;
		
		if(num == 0) System.out.println("00");
		else if(num<10) System.out.println("0" + num);
		else System.out.println(num);

	}

}
