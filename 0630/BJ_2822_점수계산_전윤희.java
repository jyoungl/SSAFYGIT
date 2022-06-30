package 기타;

import java.io.*;
import java.util.*;

class Quiz implements Comparable<Quiz> {
	int score;
	int index;

	public Quiz(int score, int index) {
		this.score = score;
		this.index = index;
	}

	@Override
	public int compareTo(Quiz o) { // 내림차순 정렬(\)
		return o.score - this.score; // 양수
	}

}

public class BJ_2822_점수계산_ArrayList {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		ArrayList<Quiz> quiz = new ArrayList<Quiz>();
		// 8문제
		for (int i = 1; i <= 8; i++) {
			quiz.add(new Quiz(in.nextInt(), i));
		}
		Collections.sort(quiz);

		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += quiz.get(i).score;
		}
		System.out.println(sum);

		// 문제 번호도 정렬이 필요함
		int[] index = new int[5];
		for (int i = 0; i < 5; i++) {
			index[i] = quiz.get(i).index;
		}
		Arrays.sort(index);

		for (int i = 0; i < 5; i++) {
			System.out.print(index[i] + " ");
		}
	}

}
