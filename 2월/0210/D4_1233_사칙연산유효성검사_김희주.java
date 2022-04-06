import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D4_1233_사칙연산유효성검사 {
	static char[] equation;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=10;tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(in.readLine());
			equation = new char[N+1];
			
			//탐색
			boolean check = true;
			for(int i=1;i<=N;i++) {
				String[] tmp = in.readLine().split(" ");
				if(tmp.length<=2) {//2초과이면(자식있으면) 부호여야함. 2이하면(자식없으면) 무조건 숫자
					try {
						Integer.parseInt(tmp[1]);
					}
					catch(NumberFormatException e) {
						check=false;
						for(i=i+1;i<=N;i++) in.readLine();	//교수님 코드 추가!
					}
				}
			}

			//출력
			if(check) sb.append(1);
			else sb.append(0);
			
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
