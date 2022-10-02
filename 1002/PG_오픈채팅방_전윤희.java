package day_1002;

import java.io.*;
import java.util.*;

/** Programmers 2019 KAKAO BLIND RECRUITMENT 오픈채팅방 **/
// 주의 : 닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경된다
public class Solution {
	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(solution(record));
	}

	private static String[] solution(String[] record) {
		// StringBuilder sb = new StringBuilder();
		HashMap<String, String> hm = new HashMap<>();

		// answer 길이를 안정하고 어떻게 접근해야하지? → 배열 길이 상관없는 ArrayList로 접근해서 size로 반환
		ArrayList<String> log = new ArrayList<>();

		for (int i = 0; i < record.length; i++) {
			// 공백 단위로 끊어 읽어서
			String[] str = record[i].split(" ");

			if (str[0].equals("Enter") || str[0].equals("Change")) {
				// 인덱스 첫번째 부분을 해시맵에 넣어준다
				hm.put(str[1], str[2]);
			}

			// 첫단어 (Enter, Leave)에 따라 처리
			if (str[0].equals("Enter")) {
				log.add(str[1] + "님이 들어왔습니다.");
			} else if (str[0].equals("Leave")) {
				log.add(str[1] + "님이 나갔습니다.");
			}
		}

		String[] answer = new String[log.size()];
		int idx = 0;
		for (String line : log) {
			String uid = "";
			String[] token = line.split(" ");
			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == '님')
					break;
				uid += line.charAt(j);
				/** 틀린 이유 : if 문 위치가 이 곳이면 uid는 '님'까지 포함된다! **/
//				if (line.charAt(j) == '님')
//					break;
			}
//			System.out.println("uid: "+uid);
			answer[idx++] = line.replace(token[0], hm.get(uid) + "님이");
		}

		return answer;

	}

}
