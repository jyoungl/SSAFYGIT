import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class BOJ_1269_대칭차집합 {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> mapA = new HashMap<>();
		Map<Integer, Integer> mapA2 = new HashMap<>();
		st = new StringTokenizer(in.readLine());

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			mapA.put(temp, i);
			mapA2.put(i, temp);
		}

		Map<Integer, Integer> mapB = new HashMap<>();
		Map<Integer, Integer> mapB2 = new HashMap<>();
		st = new StringTokenizer(in.readLine());

		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			mapB.put(temp, i);
			mapB2.put(i, temp);
		}
		ArrayList<Integer> AB = new ArrayList<>();

		// A-B
		for (int i = 0; i < N; i++) {
			if (!mapB.containsKey(mapA2.get(i))) {
				AB.add(mapA2.get(i));
			}
		}
		ArrayList<Integer> BA = new ArrayList<>();

		// B-A
		for (int i = 0; i < M; i++) {
			if (!mapA.containsKey(mapB2.get(i))) {
				BA.add(mapB2.get(i));
			}
		}
//		System.out.println(AB);
//		System.out.println(BA);
		int answer = AB.size() + BA.size();

		System.out.println(answer);
	}

}
