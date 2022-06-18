import java.io.*;
import java.util.*;

public class Main {
	class Student implements Comparable<Student> {
		String name;
		int k; // 1순위
		int e; // 2순위
		int m; // 3순위

		public Student(String name, int k, int e, int m) {
			this.name = name;
			this.k = k;
			this.e = e;
			this.m = m;
		}

		// 1순위 국어(k), 2순위 영어(e), 3순위 수학(m), 4순위: 이름(name)
		// 국어내림차순
		// 영어올림차순
		// 수학내림차순
		// 이름오름차순
		@Override
		public int compareTo(Student s) { // (전달받은현재객체)
			if (this.k == s.k) {
				if (this.e == s.e) {
					if (this.m == s.m) {
						if (this.name == s.name) {

						} else {
							return this.name.compareTo(s.name);
						}
					} else {
						return Integer.compare(s.m, this.m); // 3순위
					}
				} else {
					return Integer.compare(this.e, s.e); // 2순위
				}
			} else {
				return Integer.compare(s.k, this.k); // 1순위
			}
			return 0;
		}

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			StringBuilder sb = new StringBuilder();

			int tc = Integer.parseInt(br.readLine());
			PriorityQueue<Student> pq = new PriorityQueue<>();
			for (int i = 0; i < tc; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String name = st.nextToken();
				int korea = Integer.parseInt(st.nextToken());
				int english = Integer.parseInt(st.nextToken());
				int math = Integer.parseInt(st.nextToken());
				pq.add(new Student(name, korea, english, math));
			}
			for (int i = 0; i < tc; i++) {
				System.out.println(pq.poll().name);
//				System.out.println(pq.poll().toString());
			}

		}

	}
