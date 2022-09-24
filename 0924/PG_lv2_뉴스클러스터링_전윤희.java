package day_0924;

import java.io.*;
import java.util.*;

/** Programmers 2018 KAKAO [1차] 뉴스 클러스터링 **/
public class Solution2 {
	static String str1, str2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		System.out.println(solution(str1, str2));

	}

	private static int solution(String str1, String str2) {
		// 대소문자 구분 X
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		ArrayList<String> basket1 = new ArrayList<>();
		ArrayList<String> basket2 = new ArrayList<>();
		ArrayList<String> union = new ArrayList<>();
		ArrayList<String> intersection = new ArrayList<>();

		// 입력값 1
		for (int i = 0; i < str1.length() - 1; i++) {
			// 입력으로 들어온 문자열은 두 글자씩 끊어서
			char c1 = str1.charAt(i);
			char c2 = str1.charAt(i + 1);

			// 영문자로 된 글자 쌍만 유효
			// 숫자(0~9)가 48번 - 57번
			// 알파벳 대문자(A~Z)는 65번 - 90번
			// 알파벳 소문자(a~z)는 97번 - 122번
			if (c1 < 65 || c2 < 65 || c1 > 90 || c2 > 90) {
				continue;
			}

			// 문자를 문자열로 합쳐서
			String str = String.valueOf(c1) + String.valueOf(c2);

			// 리스트에 저장
			basket1.add(str);

		}

		// 입력값 2
		for (int i = 0; i < str2.length() - 1; i++) {
			char c1 = str2.charAt(i);
			char c2 = str2.charAt(i + 1);

			if (c1 < 65 || c2 < 65 || c1 > 90 || c2 > 90) {
				continue;
			}

			String str = String.valueOf(c1) + String.valueOf(c2);

			basket2.add(str);

		}

		// basket1에 있는 원소가 basket2에 있으면 교집합에 추가해주고, 디폴트로 합집합 처리
		for (String s : basket1) {
			System.out.println("s: " + s);
			union.add(s);
			out: for (String s_compare : basket2) {
				System.out.println("s_compare: " + s_compare);
//				if(s==s_compare) {
				if (s.equals(s_compare)) {
					// 교집합에도 넣어주고
					System.out.println("intersection 문자열: " + s);
					intersection.add(s);
					
					/** [오류 발생 이유]
					 * 데이터를 ArrayList에 담아서 작업 도중 유효성 검사 등을 통해서 조건에 맞지 않는것을 삭제할 때, 
					 * 루프(loop)를 돌면서 유효성을 체크해서 삭제를 하는데, 일반적인 for 루프를 사용하면 예외가 발생하거나 원하는 결과를 얻지 못할 수 있습니다.
					 * 삭제를 해버리면 내부적으로 루핑을 돌기 위해 사용하는 list의 크기와 처리해야할 항목을 가리키는 인덱스의 불일치 때문에 에러 또는 논리적인 오류가 발생합니다.
					 * 즉, List와 같은 객체를 for each 문을 돌릴 때, 해당 객체를 수정하면 발생한다. 
					 * 그리고 보통 해당상황이 발생하는 경우는 크게 두가지 경우가 있다고 한다.
					 * - 싱글 스레드 환경에서 for each문 중간에 객체를 수정하는 경우
					 * - 멀티 스레드 환경에서, 다른 스레드에서 객체 값이 수정된 경우.
					 * 결론적으로 이를 해결하기 위해서는 for each 중에는 객체를 수정하지 않는다. 
					 * 만약 수정해야 한다면 바로 break로 반복문을 빠져 나온다.
					 */
					basket2.remove(s_compare);
					break out;
				}
			}
		}
		
		for (String s : basket2) {
			union.add(s);
		}
		double answer = 0;

		// 집합 A,B 모두 공집합 일 때는 자카드 유사도 = 1
		if (union.size() == 0) {
			answer = 1;
		} else {
			// int unionSize = (basket1.size()-intersection.size()) + (basket2.size()-intersection.size()) + intersection.size();
			System.out.println("intersection.size(): " + intersection.size());
			System.out.println("union.size(): " + union.size());
			answer = (double) intersection.size() / (double) union.size();
		}

		// 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력
		return (int) (answer * 65536);
	}

}
