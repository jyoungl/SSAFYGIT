package lv27_트리;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 노드의 개수 n
 * 2. 부모 노드의 번호 n1 자식 노드 n2 간선의 가중치 n3
 * 출력
 * 1. 트리의 지름
 */
public class g4_1967_트리의지름 {
	static int max, node;
	static boolean[] visit;
	static ArrayList<int[]>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N==1) {
			System.out.println(0);
			System.exit(0);
		} 
		
		list = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
 
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());

			list[n1].add(new int[] {n2, n3});
			list[n2].add(new int[] {n1, n3});
		}

		dfs(1, 0);
		
		visit = new boolean[N + 1];
		
		dfs(node, 0);
		
		System.out.println(max);

	}

	public static void dfs(int v, int len) {
		if(len>max) {
			max = len;
			node = v;
		}
		
		visit[v] = true;

		for (int[] i : list[v]) {
			if (!visit[i[0]]) {
				visit[i[0]] = true;
				dfs(i[0], len+i[1]);
			}
		}
	}

}
