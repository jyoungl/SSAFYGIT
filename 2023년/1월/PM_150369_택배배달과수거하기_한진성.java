public class PM_150369_택배배달과수거하기_한진성 {

	public static void main(String[] args) {
		System.out.println(solution(2, 2, new int[] { 0, 0 }, new int[] { 0, 4 }));
	}

	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long total = 0;
		// 거꾸로 풀기
		for (int i = n - 1; i >= 0; i--) {
			// 배달 캡
			int tempCap = cap;
			// 회수 캡
			int tempCap2 = cap;
			
			// 가장 멀리 있는 칸인데 아직 뭐가 남았으면 체크
			boolean check = false;
			
			// 가장 멀리 있는 칸인데 칸에 뭐가 있으면 ㄱㄱ
			if (deliveries[i] != 0 || pickups[i] != 0) {
				// 배달 캡 만큼 뒤에서부터 0 처리하기
				for (int j = i; tempCap >= 0; j--) {
					// 젤 첨까지 왔으면 끝
					if (j < 0) {
						break;
					}
					// 배달 캡에서 칸에 있는 수 만큼 빼기
					tempCap -= deliveries[j];
					// 캡보다 칸이 더 많을 때
					if (tempCap < 0) {
						// 절댓값으로 돌려주기
						deliveries[j] = Math.abs(tempCap);
						
						// 많약 캡보다 칸이 더 많으면 이거 체크 트루로 바꿔줘야함(가장 멀리 있는 칸인데 뭐가 남은 경우)
						if (j == i) {
							check = true;
						}
						break;
					} else {
						// 배달 칸 0처리
						deliveries[j] = 0;
					}
					// 만약 캡 다 떨어지면 나가기
					if (tempCap == 0) {
						break;
					}
				}
				// 회수 캡 만큼 뒤에서부터 0 처리하기 (아래는 위에꺼 복사)
				for (int j = i; tempCap2 >= 0; j--) {
					if (j < 0) {
						break;
					}
					tempCap2 -= pickups[j];
					if (tempCap2 < 0) {
						pickups[j] = Math.abs(tempCap2);
						if (j == i) {
							check = true;
						}
						break;
					} else {
						pickups[j] = 0;
					}
					if (tempCap2 == 0) {
						break;
					}

				}
				// 가장 멀리 있는 칸 *2 만큼 더해주기
				total += ((i + 1)*2);
				// 아까 말했던 가장 멀리 있는 칸인데 뭐가 더 남았으면 거기를 다시 탐색해야 되니까 i++하기
				if (check) {
					i++;
				}

			}
		}
		return total;
	}

}
