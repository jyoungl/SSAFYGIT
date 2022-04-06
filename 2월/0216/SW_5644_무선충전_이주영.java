import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_5644_무선충전_이주영 {
	//0 제자리, 1상, 2우, 3하, 4좌
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int T = Integer.parseInt(br.readLine());
		 
		 for(int tc=1;tc<=T;tc++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 int M = Integer.parseInt(st.nextToken());
			 int A = Integer.parseInt(st.nextToken());
			 int[] amove = new int[M+1];
			 int[] bmove = new int[M+1];
			 int ax=1, ay=1;
			 int bx=10, by=10;
			 int res = 0;
			 
			 //A 이동 저장
			 st = new StringTokenizer(br.readLine());
			 amove[0] = 0; bmove[0] = 0; //맨 처음 시작 위치 세기 위해 삽입
			 for(int i=1;i<=M;i++)
				 amove[i] = Integer.parseInt(st.nextToken());
			 //B 이동 저장
			 st = new StringTokenizer(br.readLine());
			 for(int i=1;i<=M;i++)
				 bmove[i] = Integer.parseInt(st.nextToken());
			 
			 int[][] BC = new int[A+1][4]; //좌표 xy, 충전범위, 처리량
			 //충전기 정보 저장
			 for(int i=1;i<=A;i++) {
				 st = new StringTokenizer(br.readLine());
				 BC[i][0] = Integer.parseInt(st.nextToken()); //좌표 x
				 BC[i][1] = Integer.parseInt(st.nextToken()); //좌표 y
				 BC[i][2] = Integer.parseInt(st.nextToken()); //충전범위
				 BC[i][3] = Integer.parseInt(st.nextToken()); //처리량
			 }
			 
			 ArrayList<Integer> listA = new ArrayList<>();
			 ArrayList<Integer> listB = new ArrayList<>();
			 int ap = 0, bp = 0;
			 //시간(M)만큼 반복문 돌림
			 for(int i=0;i<=M;i++) {
				 int max = 0;
				 int xa = ax + dr[amove[i]];	int ya = ay + dc[amove[i]]; //해당 시간의 사용자A 좌표
				 int xb = bx + dr[bmove[i]];	int yb = by + dc[bmove[i]]; //사용자B의 좌표
				 //해당 위치에서 사용 가능한 충전기 리스트에 넣기
				 for(int j=1;j<=A;j++) {
					 int Da = Math.abs(xa - BC[j][0]) + Math.abs(ya - BC[j][1]); //A와 충전기 사이 거리
					 int Db = Math.abs(xb - BC[j][0]) + Math.abs(yb - BC[j][1]); //B와 충전기 사이 거리
					 
					 if(Da <= BC[j][2])
						 listA.add(j); //list에 가능한 충전소의 인덱스 넣음
					 if(Db <= BC[j][2])
						 listB.add(j);
				 }

				 //리스트 안의 충전기들 비교
				 if(listA.size() == 0 && listB.size() == 0) {
					 res +=0;
					 continue;
				 }
				 else if(listA.size() == 0) {
					 for(int z=0;z<listB.size();z++) {
						 int sum = BC[listB.get(z)][3];
						 bp = sum > bp ? sum : bp ;
					 }
				 }
				 else if(listB.size() == 0) {
					 for(int z=0;z<listA.size();z++) {
						 int sum = BC[listA.get(z)][3];
						 ap = sum > ap ? sum : ap ;
					 }
				 }
				 else {
					 for(int n=0;n<listA.size();n++) {
						 for(int m=0;m<listB.size();m++) {
							 int sum = 0;
							 
							 if(n == m) {
								 sum = BC[listA.get(n)][3];
								 
								 if(sum > max) {
									 ap = sum/2;
									 bp = sum/2;
									 max = sum;
								 }
							 }
							 else {
								 sum = BC[listA.get(n)][3] + BC[listB.get(m)][3];
								 
								 if(sum > max) {
									 ap = BC[listA.get(n)][3];
									 bp = BC[listB.get(m)][3];
									 max = sum;
								 }
							 }
								 
						 }
					 }
				 }
				 res += ap + bp;
			 }
		 System.out.println("#"+tc+" "+res);
		 }
		 
		 
	}

}
