import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());		
		int[][] meeting = new int[n][2];//0 시작시간, 1 종료시간
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		br.close();

		Arrays.sort(meeting,new Comparator<>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				//끝나는 시간으로 정렬하되 같으면 시작시간이 더 빠른 순으로
				return o1[1]==o2[1]? o1[0] - o2[0] : o1[1] - o2[1];
			}
		});
		
		int lastTime = 0;
		int ans = 0;
		for(int i=0;i<n;i++) {
			if(lastTime<=meeting[i][0]) {
				lastTime = meeting[i][1];
				ans++;
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(ans));
		
		bw.flush();
		bw.close();
	}
}
