package jan09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1931_회의실배정_이주영 {
	public static class Room {
		int s;
		int e;
		
		public Room(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<Room> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Room(x,y));
		}
		
		list.sort(new Comparator<Room>(){
			@Override
			public int compare(Room o1, Room o2) {
				if(o1.e == o2.e)
					return o1.s -o2.s;
				return o1.e - o2.e;
			}
		});
		
		System.out.println(greedy(list));
	}
	
	public static int greedy(ArrayList<Room> list) {
		int time = 0;
		int ans = 0;
		
		for(Room r : list) {
			if(time <= r.s) {
				time = r.e;
				ans++;
			}
		}
		
		return ans;
	}

}
