import java.io.*;
import java.util.*;

public class BOJ_1991_트리순회 {
	static StringBuilder sb = new StringBuilder();
	static int[][] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;

		tree = new int[N][2];

		for(int i=0;i<N;i++){
			//.에서 A빼면 -19
			st = new StringTokenizer(in.readLine());
			int node = st.nextToken().charAt(0)-'A';
			tree[node][0] = st.nextToken().charAt(0)-'A';
			tree[node][1] = st.nextToken().charAt(0)-'A';
		}

		preorder(0);
		sb.append('\n');
		inorder(0);
		sb.append('\n');
		postorder(0);

		System.out.println(sb);
	}

	private static void preorder(int i) {
		sb.append((char)(i+'A'));
		if(tree[i][0]>0) preorder(tree[i][0]);
		if(tree[i][1]>0) preorder(tree[i][1]);

	}

	private static void inorder(int i) {
		if(tree[i][0]>0) inorder(tree[i][0]);
		sb.append((char)(i+'A'));
		if(tree[i][1]>0) inorder(tree[i][1]);
	}

	private static void postorder(int i) {
		if(tree[i][0]>0) postorder(tree[i][0]);
		if(tree[i][1]>0) postorder(tree[i][1]);
		sb.append((char)(i+'A'));
	}


}
