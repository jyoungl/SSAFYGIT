import java.io.*;
import java.util.*;

public class BOJ_17140_이차원배열과연산 {
	static int r, c, k;//A[r][c]==k
	static int[][] A = new int[101][101];
	static int R, C;//현재 행, 열 크기

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		R = C = 3;

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= C; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		boolean state = true;//true : 원래 배열, false : 90도 회전 배열
		while (time <= 100) {
			if (state && r <= R && c <= C && A[r][c] == k) {
				System.out.println(time);
				return;
			}

			if (!state && r <= C && c <= R && A[c][r] == k) {
				System.out.println(time);
				return;
			}

			//R<C이거나(원래의 C연산) 90도 회전인 상태에서 R==C이면 돌림
			if(R<C || R == C && !state) {
				rotate();
				state = !state;
			}

			sort();
			time++;

		}

		System.out.println(-1);
	}

	//90도 회전
	private static void rotate() {
		int[][] next = new int[101][101];
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				next[j][100 - i] = A[i][j];
			}
		}
		//A 교체
		A = next;

		//R,C 교체
		int tmp = R;
		R = C;
		C = tmp;
	}

	private static void sort() {
		int[] tmp;
		int idx;
		int nc = 0;
		ArrayList<Item> list = new ArrayList<>();

		for (int i = 1; i <= R; i++) {
			Arrays.sort(A[i]);
			//오름차순 정렬 했으므로 거꾸로 돌림(어차피 collections.sort쓸거라서 괜찮음)
			//0 발견하면 바로 멈춤
			for(int j=100,k=100;j>0;j=k){
				if(A[i][j]==0) break;
				while(k>=0 && A[i][j]==A[i][k]) k--;
				list.add(new Item(A[i][j], j-k));
			}

			//리스트 정렬. 횟수 오름차순->값 오름차순
			Collections.sort(list);
			tmp = new int[101];
			idx = 0;
			//리스트에 담긴 아이템 하나씩 꺼내서 담음
			for (Item item : list) {
				if(item.value==0) continue;
				tmp[++idx] = item.value;
				tmp[++idx] = item.count;
			}
			//최대 인덱스 저장
			nc = Math.max(nc, idx);
			//A[i] 교체
			A[i] = tmp;
			//리스트 비움
			list.clear();
		}

		//최대 인덱스를 새로운 C로 삼음
		C = nc;
	}

	private static class Item implements Comparable<Item> {
		int value;
		int count;

		Item(int value, int count) {
			this.value = value;
			this.count = count;
		}

		@Override
		public int compareTo(Item o) {
			if (this.count == o.count) return this.value - o.value;
			return this.count - o.count;
		}
	}
}
