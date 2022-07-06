package 기타;

import java.util.*;
import java.io.*;

public class BJ_11048_이동하기 {
	static int[][] maze;
	static int R, C;

//	static int[] dr = { 0, 1, 1 };
//	static int[] dc = { 1, 1, 0 };

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		R = in.nextInt();
		C = in.nextInt();
		maze = new int[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				maze[i][j] = in.nextInt();
			}
		}
		
		// DP : 왼/위/왼위
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				maze[i][j] += Math.max(maze[i][j - 1], Math.max(maze[i - 1][j], maze[i - 1][j - 1]));
			}
		}

		System.out.println(maze[R][C]);
	}

}
