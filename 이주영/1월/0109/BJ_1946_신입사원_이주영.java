package jan09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Student{
	int grade;
	int rank;
	
	public Student(int g, int r) {
		this.grade = g;
		this.rank = r;
	}
}

public class BJ_1946_신입사원_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Student> list = new ArrayList<>();
			
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Student(x,y));
			}
			
			list.sort(new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.grade - o2.grade;
				}
			});
			
			sb.append(greedy(list)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int greedy(ArrayList<Student> list) {
		int grade = Integer.MAX_VALUE;
		int ans = 0;
		
		for(Student s : list) {
			if(grade >= s.rank) {
				grade = s.rank;
				ans++;
			}
		}
		
		return ans;
	}

}
