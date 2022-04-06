import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 배달해야 하는 장소의 수 N(출발지는 1)
 * 2. 장소와 이동하는 비용(간선)
 * 출력
 * 1. 최소 비용
 * 
 * >> dfs, 순열
 */
public class JO_1681_해밀턴순환회로_허은지 {
	static int N, distance, min = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,1,0);
		
		System.out.println(min);
		
	}

	private static void dfs(int start, int cnt, int distance) {
		//거리가 min보다 크면 리턴
		if(distance > min) return;
		
		//모든 곳을 다 방문했을 때
		if(cnt==N) {
			//회사로 다시 돌아갈 수 있는 길이 있다면
			if(arr[start][0]!=0)
			//최솟값 구하기
			min = Math.min(min, distance+arr[start][0]);
		}
		
		//회사는 0이니까 1부터 N까지
		for(int i = 1; i<N; i++) {
			//i로 갈 수 있는 길이 있고 방문한 적 없으면
			if(arr[start][i]!=0 && !visited[i]) {
				//방문했다고 체크
				visited[i] = true;
				//방문한 곳에서 다시 탐색
				dfs(i, cnt+1, distance + arr[start][i]);
				visited[i] = false;
			}
		}
		
	}
}
