import java.io.*;
import java.util.*;

public class BOJ_10825_국영수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Student[] students = new Student[N];
		StringTokenizer st;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			students[i] = new Student(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken());
		}
		Arrays.sort(students);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			sb.append(students[i].name).append('\n');
		}
		System.out.print(sb);
	}

	private static class Student implements Comparable<Student> {
		String name;
		int korean,math,english;

		Student(String name, String korean, String english, String math){
			this.name = name;
			this.korean = Integer.parseInt(korean);
			this.math = Integer.parseInt(math);
			this.english = Integer.parseInt(english);
		}
		@Override
		public int compareTo(Student o) {
			if(this.korean != o.korean) return o.korean-this.korean;
			else if(this.english != o.english) return this.english - o.english;
			else if(this.math != o.math) return o.math - this.math;
			else return this.name.compareTo(o.name);
		}
	}
}

