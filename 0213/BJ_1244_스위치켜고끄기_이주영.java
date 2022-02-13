package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244_스위치켜고끄기_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 스위치 개수
		boolean[] swh = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x == 1)
				swh[i] = !swh[i];
		}
		
		int stu = Integer.parseInt(br.readLine()); //학생 수
		
		for(int i=0;i<stu;i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken()); //학생의 성별
			int num = Integer.parseInt(st.nextToken()); //뽑은 번호
			if(gender == 1) { //남자라면
				for(int j=1;j<=N;j++) {
					if(j%num == 0)
						swh[j] = !swh[j];
				}
			}
			else if(gender == 2) { //여자라면
				int d = 1;
				while(true) {
					if(num-d>=1 && num+d <=N && swh[num-d] == swh[num+d]) {
						swh[num-d] = !swh[num-d];
						swh[num+d] = !swh[num+d];
						d++;
					}
					else {
						swh[num] = !swh[num];
						break;
					}
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(swh[i])
				sb.append("1 ");
			else
				sb.append("0 ");
			
			if(i%20 == 0)
				sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}

}
