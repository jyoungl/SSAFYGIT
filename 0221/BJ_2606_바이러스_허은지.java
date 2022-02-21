package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 컴퓨터의 수
 * 2. 직접 연결되어 있는 컴퓨터 쌍의 수
 * 3. 직접 연결되어 있는 컴퓨터의 번호 쌍
 * 출력
 * 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
 * 
 * >> DFS or BFS
 */
public class s3_2606_바이러스 {
	static int N, M, ans;
	static int[][] arr;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		isSelected = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			arr[n1][n2] = arr[n2][n1] = 1; //양방향
		}
		
		//dfs(1);
		bfs();
		System.out.println(ans);
		
	}
	
	

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1); //queue에 시작하는 숫자 추가
		isSelected[1] = true; //시작하는 숫자 방문 체크
		while(!queue.isEmpty()) { //큐가 빌 때까지
			int num = queue.poll(); //숫자 하나씩 꺼내서 체크
			for(int i = 0; i<N+1; i++) {
				if(arr[num][i]==1 & isSelected[i]==false) { //꺼낸 숫자와 i를 잇는 선이 있고 i를 방문한 적 없을 때
					isSelected[i] = true; //i 방문 체크
					queue.add(i); //i 다음부터 다시 체크하기 위해 큐에 넣음
					ans++;
				}
			}
		}
		
	}

	private static void dfs(int start) {
		for(int i = 0; i<N+1; i++) {
			isSelected[start] = true;
			if(arr[start][i]==1 && !isSelected[i]) { //start와 i를 잇는 선이 있고 i를 방문한 적 없을 때
				dfs(i);
				ans++;
			}
		}
		
	}
	
	
}
