import java.util.Arrays;
import java.util.PriorityQueue;

public class PG_디스크컨트롤러 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{0,3},{1,9},{2,6}}));
	}

	public static int solution(int[][] jobs) {
		Arrays.sort(jobs,(o1,o2)->o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1]);
		PriorityQueue<int[]> pQueue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		pQueue.offer(jobs[0]);

		int result = 0, idx = 1, time = jobs[0][0];
		int[] now;

		while(!pQueue.isEmpty()){
			//뽑기
			now = pQueue.poll();
			time += now[1];
			result += time+now[0];


			//다음 job이 남아있는 경우
			while(idx<jobs.length && jobs[idx][0]<=time) pQueue.offer(jobs[idx++]);

			//job 남았는데 queue 비었으면 time 재설정
			if(idx<jobs.length && pQueue.isEmpty()){
				time = jobs[idx][0];
				pQueue.offer(jobs[idx++]);
			}
		}

		return result/jobs.length;
	}
}
