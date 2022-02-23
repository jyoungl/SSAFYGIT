import java.io.*;
import java.util.*;

public class BOJ_15686_치킨배달 {
	static Chicken[][] distances;
	static int MIN = Integer.MAX_VALUE;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		List<Chicken> chickens = new ArrayList<>();
		List<House> houses = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				switch (st.nextToken()) {
					case "1":
						houses.add(new House(i, j));
						break;
					case "2":
						chickens.add(new Chicken(i, j, chickens.size()));
						break;
				}
			}
		}

		//거리계산 & 가까운 순으로 정렬
		distances = new Chicken[houses.size()][chickens.size()];

		for (int i = 0; i < distances.length; i++) {
			for (int j = 0; j < distances[i].length; j++) {
				distances[i][j] = new Chicken(chickens.get(j),houses.get(i));
			}
			Arrays.sort(distances[i]);
		}

		findC(0,0,0);

		System.out.println(MIN);

	}

	private static void findC(int cnt, int start, int flag){
		if(cnt==M){
			//계산 - 정렬된 거리들 첫번째부터 보면서 그 인덱스가 뽑힌 상태라면 바로 break;
			int sum = 0;
			for(int i=0;i<distances.length;i++){
				for(int j=0;j<distances[i].length;j++){
					if((flag&1<<distances[i][j].index)!=0){
						sum += distances[i][j].distance;
						break;
					}
				}
			}

			MIN = Math.min(MIN,sum);
			return;
		}

		//치킨집 개수만큼 돌면서 하나씩 뽑음
		for(int i=start;i<distances[0].length;i++){ 
			if((flag&1<<i)!=0) continue;
			findC(cnt+1,i,flag|1<<i);
		}
	}

	static class House {
		int x, y;

		private House(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	static class Chicken implements Comparable<Chicken>{
		int x, y;
		int index;
		int distance;

		private Chicken(int y, int x, int index) {
			this.x = x;
			this.y = y;
			this.index = index;
		}

		private Chicken(Chicken chicken, House house){
			this(chicken.y,chicken.x,chicken.index);
			this.distance = calcDistance(house);
		}

		private int calcDistance(House house) {
			return Math.abs(this.x - house.x) + Math.abs(this.y - house.y);
		}

		@Override
		public int compareTo(Chicken o) {
			return this.distance-o.distance;
		}
	}
}
