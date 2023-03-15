import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19236_청소년상어_한진성 {
	static Fish[][] arr;
	static int max = Integer.MIN_VALUE;
	static int[][] dir = new int[][] { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 },
			{ 0, 1 }, { -1, 1 } };
	static int ARR_MAX = 4;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		arr = new Fish[ARR_MAX][ARR_MAX];

		for (int i = 0; i < ARR_MAX; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < ARR_MAX; j++) {

				arr[i][j] = new Fish(i, j, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			}

		}
		// 상어 0,0 배치
		Fish shark = new Fish(0, 0, -1, arr[0][0].dir);
		int start = arr[0][0].num;
		arr[0][0] = shark;
		game(arr, start);
		System.out.println(max);
	}

	static void game(Fish[][] map, int eat) {

		Fish[][] nextMap = new Fish[ARR_MAX][ARR_MAX];
		// 맵 복사
		Fish shark = null;
		List<Fish> fishList = new ArrayList<>();
		for (int i = 0; i < ARR_MAX; i++) {
			for (int j = 0; j < ARR_MAX; j++) {
				nextMap[i][j] = new Fish(map[i][j].x, map[i][j].y, map[i][j].num, map[i][j].dir);
				if(nextMap[i][j].num == -1) {
					shark = nextMap[i][j];
					continue;
				}
				if(nextMap[i][j].num == -2) {
					continue;
				}
				fishList.add(nextMap[i][j]);
			}
		}
		Collections.sort(fishList);
		// 1. 물고기 이동
		for (int i = 0, n = fishList.size(); i < n; i++) {
			Fish fish = fishList.get(i);
			for (int j = 0; j < 8; j++) {

				int dx = fish.x + dir[fish.dir][0];
				int dy = fish.y + dir[fish.dir][1];
				if (dx < 0 || dx >= ARR_MAX || dy < 0 || dy >= ARR_MAX || nextMap[dx][dy].num == -1) {
					fish.dir++;
					if (fish.dir == 9) {
						fish.dir = 1;
					}
					continue;
				}
				nextMap[dx][dy].x = fish.x;
				nextMap[dx][dy].y = fish.y;
 				nextMap[fish.x][fish.y] = nextMap[dx][dy];
				nextMap[dx][dy] = fish;
				fish.x = dx;
				fish.y = dy;				
				break;
			}
		}
		// 이동 완료 확인
//		for(int i=0;i<ARR_MAX;i++) {
//			for(int j=0;j<ARR_MAX;j++) {
//				System.out.print(nextMap[i][j].num + "\t");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i=0;i<ARR_MAX;i++) {
//			for(int j=0;j<ARR_MAX;j++) {
//				System.out.print(nextMap[i][j].dir + "\t");
//			}
//			System.out.println();
//		}
//		System.out.println();
		// 2. 상어 이동 - 상어가 이동가능 한 지 확인
		
		for(int i=1;i<ARR_MAX;i++) {
			
			int dx = shark.x + dir[shark.dir][0]*i;
			int dy = shark.y + dir[shark.dir][1]*i;
			
			Fish[][] tempMap = new Fish[ARR_MAX][ARR_MAX];
			for(int j=0;j<ARR_MAX;j++) {
				for(int k=0;k<ARR_MAX;k++) {
					tempMap[j][k] = new Fish(nextMap[j][k].x, nextMap[j][k].y, nextMap[j][k].num, nextMap[j][k].dir);
				}
			}
			if(dx < 0 || dx >= ARR_MAX || dy < 0 || dy >= ARR_MAX || tempMap[dx][dy].num == -2) {
				max = Math.max(max, eat);

//				System.out.println(max);
//				System.out.println("=============================================");
				continue;
			}
			
			Fish tempShark = new Fish(shark.x,shark.y,shark.num,shark.dir);
			tempMap[dx][dy].x = tempShark.x;
			tempMap[dx][dy].y = tempShark.y;
			int eatCnt = tempMap[dx][dy].num;
			eat += eatCnt;
//			System.out.println("+++++++++++++++");
//			System.out.println(tempMap[dx][dy].num);
//			System.out.println(eat);
//			System.out.println("+++++++++++++++");
			tempMap[dx][dy].num = -2;
			tempShark.dir = tempMap[dx][dy].dir;
//			System.out.println("------------------------------");
//			System.out.println(tempShark.dir);
//			System.out.println("------------------------------");
			tempMap[tempShark.x][tempShark.y] = tempMap[dx][dy];
			tempMap[dx][dy] = tempShark;
			tempShark.x = dx;
			tempShark.y = dy;
			
			game(tempMap, eat);
			eat -= eatCnt;
		}
		
		
	}
	
	static class Fish implements Comparable<Fish> {

		int x;
		int y;
		int num;
		int dir;

		public Fish() {
		}

		public Fish(int x, int y, int num, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}

		@Override
		public int compareTo(Fish o) {
			// TODO Auto-generated method stub
			return this.num - o.num;
		}

	}

}
