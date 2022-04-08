package lv27_트리;

import java.io.*;
import java.util.*;

public class S1_1991_트리순회 {
	static String str = "";
	static int N, tree[][];
	
	static class Node {
		int left;
		int right;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;

		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tree = new int[26][2];
		
		for(int i=1; i<N+1; i++) {
			String[] line = br.readLine().split(" ");
			int data = line[0].charAt(0) -'A';
			int left = line[1].charAt(0) -'A';
			int right = line[2].charAt(0) -'A';
			
			tree[data][0] = left;
			tree[data][1] = right;
		}
		
		System.out.println(preorder(0));
		str = "";
		System.out.println(inorder(0));
		str = "";
		System.out.println(postorder(0));

	}
	
	public static String preorder(int start) {
		if(start == -19) return str;
		
		str += (char)(start+'A');
		preorder(tree[start][0]);
		preorder(tree[start][1]);
		
		return str;
	}
	
	public static String inorder(int start) {
		if(start == -19) return str;
		
		inorder(tree[start][0]);
		str += (char)(start+'A');
		inorder(tree[start][1]);
		
		return str;
	}
	
	public static String postorder(int start) {
		if(start == -19) return str;
		
		postorder(tree[start][0]);
		postorder(tree[start][1]);
		str += (char)(start+'A');
		
		return str;
	}

}
