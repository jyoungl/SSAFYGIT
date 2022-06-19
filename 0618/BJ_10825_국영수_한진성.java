import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10825_국영수 {

	static class Stud implements Comparable<Stud>{
		
		String name;
		int score1;
		int score2;
		int score3;
		
		
		public Stud(String name, int score1, int score2, int score3) {
			super();
			this.name = name;
			this.score1 = score1;
			this.score2 = score2;
			this.score3 = score3;
		}


		@Override
		public int compareTo(Stud o) {
			
			if(this.score1 == o.score1 && this.score2 == o.score2 && this.score3 == o.score3) {
				return this.name.compareTo(o.name);
			}else if(this.score1 == o.score1 && this.score2 == o.score2) {
				return o.score3 - this.score3;
			}else if(this.score1 == o.score1) {
				return this.score2 - o.score2;
			}else {
				return o.score1 - this.score1;
			}
		}
		
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		Stud[] students = new Stud[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			int s3 = Integer.parseInt(st.nextToken());
			students[i] = new Stud(name,s1,s2,s3);
		}
		
		Arrays.sort(students);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(students[i].name).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
