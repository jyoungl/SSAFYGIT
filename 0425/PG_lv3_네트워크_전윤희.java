import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
       int answer = 0; // 네트워크 개수
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) { // 방문하지 않았다면
				bfs(i, computers);
				answer++;
			}
		}
		return answer;
    }
    
    public static void bfs(int x, int[][] computer) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visited[x] = true;

		while (!q.isEmpty()) {
			int y = q.poll();

			for (int i = 0; i < computer.length; i++) {
				if (!visited[i] && computer[y][i] == 1 && y != i) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}

	}
}