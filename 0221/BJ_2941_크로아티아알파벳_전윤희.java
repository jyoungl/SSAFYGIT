package com.im.baekjoon;

import java.util.*;
import java.io.*;

// 팀스터디에서 푼 문제
public class BJ_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		
		s = s.replaceAll("c=", " ");
		s = s.replaceAll("c-", " ");
		s = s.replaceAll("dz=", " ");
		s = s.replaceAll("d-", " ");
		s = s.replaceAll("lj", " ");
		s = s.replaceAll("nj", " ");
		s = s.replaceAll("s=", " ");
		s = s.replaceAll("z=", " ");
		
		System.out.println(s.length());
		
	}

}
