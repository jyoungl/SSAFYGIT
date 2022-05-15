import java.io.*;
import java.util.*;
/**
 * INPUT)
 * N: 땅의 면적 NxN (R,C = 1부터 시작), M: 초기 M개의 나무, K: K년 후
 * 땅의 면적 크기에 따른 1년후 양분 추가될 입력값을 받고
 * 상도가 심은 나무의 정보 x, y, z: (x, y) 나무의 위치, z: 나무의 나이
 * 
 * OUTPUT) 
 * K년 후 살아남은 나무의 수
 * 
 * 조건)
 * 가장 처음에 양분은 모든 칸에 5씩 있고
 * 봄: 나무 나이만큼 양분 먹고, 나이 1 증가/ 한칸에 여러나무 존재시 어린 나무부터 양분 섭취/ 양분 못먹으면 죽음
 * 여름: 죽은 나무가 양분(죽은나무 나이/2)으로 변함
 * 가을: 나이 5배수 나무가 주변으로 번식, 8방탐색 중 한곳에 나이가 1인 나무 생성
 * 겨울: 각 칸에 A[r][c]만큼 양분추가
 */

//나무 정보 저장 클래스
class Tree implements Comparable<Tree> {
	int r;
	int c;
	int age;

	Tree(int x, int y, int z) {
		this.r = x;
		this.c = y;
		this.age = z;
	}

	// 나이 오름차순으로 정렬
	@Override
	public int compareTo(Tree t) {
		return this.age - t.age;
	}

	// 디버그용
	@Override
	public String toString() {
		return "Tree [r=" + r + ", c=" + c + ", age=" + age + "]";
	}
	
}

public class BJ_16235_나무재테크 {
	static int N, M, K;
	static int[][] map; // 초기 양분 데이터를 저장한 밭
	static int[][] A; // 겨울에 양분 추가 데이터를 저장한 밭
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int x, y, z;
	
	static ArrayList<Tree> trees;
	static ArrayList<Tree> liveTrees;
	static ArrayList<Tree> deadTrees;

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		N = in.nextInt(); // 배열의 크기
		map = new int[N+1][N+1];
		A = new int[N+1][N+1];
		
		M = in.nextInt(); // M개의 나무
		K = in.nextInt(); // K년 후
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = 5;
				A[i][j] = in.nextInt();				
			}
		}
		
		trees = new ArrayList<>();
		for (int m = 0; m < M; m++) {
			x = in.nextInt();
			y = in.nextInt();
			z = in.nextInt(); // 나무 현재 나이
			trees.add(new Tree(x, y, z));
		}
		while (K > 0) { // K년이 모두 흐를때까지
			
			// 초기화 안하면 오류난다
			liveTrees = new ArrayList<>();
			deadTrees = new ArrayList<>();

			// 디버그 -1
//			for (Tree t : trees) {
//	            System.out.print(t + " ");
//	            System.out.println();
//	        }


			// 정렬 안해주면 오류난다(이클립스 콘솔창에서는 문제 없는데 백준에서 오류남)
			Collections.sort(trees);
			
			// 디버그 -2
//			for (Tree t : trees) {
//	            System.out.print(t + " ");
//	            System.out.println();
//	        }
			
			spring();
			summer();
			fall();
			winter();
			
			K--;
		}
		System.out.println(trees.size());

	}

	private static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = map[i][j] + A[i][j];
			}
		}		
	}

	private static void fall() {
		for (int i = 0; i < trees.size(); i++) {
			Tree t = trees.get(i);
			if (t.age % 5 == 0) {
				for (int j = 0; j < 8; j++) {
					int nr = t.r + dr[j];
					int nc = t.c + dc[j];
					if (1 <= nr && nr <= N && 1 <= nc && nc <= N) {
						trees.add(new Tree(nr, nc, 1));
					}
				}
			}
		}		
	}

	private static void summer() {
		for (int i = 0; i < deadTrees.size(); i++) {
			Tree t = deadTrees.get(i);
			map[t.r][t.c] = map[t.r][t.c] + t.age / 2;
		}
		
	}

	private static void spring() {
		for (int i = 0; i < trees.size(); i++) {
			Tree t = trees.get(i);
			if (t.age > map[t.r][t.c]) {
				deadTrees.add(t);
			} else {
				map[t.r][t.c] = map[t.r][t.c] - t.age;
				t.age += 1;
				liveTrees.add(t);
			}
		}
		// 나무 리스트 리셋하고 살아있는 나무로만 초기화
		trees.clear();
		trees.addAll(liveTrees);
		
	}

}