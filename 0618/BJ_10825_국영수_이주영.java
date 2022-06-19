package jun18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10825_국영수_이주영 {
	public static class Student implements Comparable<Student>{
		public String name;
		public int kor;
		public int math;
		public int eng;
		
		public Student(String name, int kor, int math, int eng) {
			this.name = name;
			this.kor = kor;
			this.math = math;
			this.eng = eng;
		}

		@Override
		public int compareTo(Student o) {
			if(this.kor == o.kor) {
				if(this.eng == o.eng) {
					if(this.math == o.math) {
						return this.name.compareTo(o.name);
					}
					return o.math - this.math;
				}
				return this.eng - o.eng;
			}
			return o.kor - this.kor;		
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Student[] s = new Student[N];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			s[i] = new Student(name, kor, math, eng);
		}
		
		Arrays.sort(s);
		
		for(int i=0;i<N;i++)
			sb.append(s[i].name+"\n");
		System.out.println(sb);
	}

}
