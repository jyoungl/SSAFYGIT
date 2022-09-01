import java.util.*;

public class PG_주차요금계산 {
	public static void main(String[] args) {
		//[14600, 34400, 5000]
		System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600},new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
		//[0, 591]
		System.out.println(Arrays.toString(solution(new int[]{120, 0, 60, 591},new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})));
		//[14841]
		System.out.println(Arrays.toString(solution(new int[]{1, 461, 1, 10},new String[]{"00:00 1234 IN"})));
	}
	public static int[] solution(int[] fees, String[] records){
		StringTokenizer st;

		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i< records.length;i++){
			st = new StringTokenizer(records[i]);
			String strtime = st.nextToken();
			int time = Integer.parseInt(strtime.substring(0,2))*60+Integer.parseInt(strtime.substring(3));
			String car = st.nextToken();
			boolean isIn = "IN".equals(st.nextToken());
			map.put(car, map.getOrDefault(car,0)+(isIn?-time:time));
		}


		ArrayList<String> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);

		int[] answer = new int[map.size()];
		for(int i=0;i<keys.size();i++) {
			answer[i] = map.get(keys.get(i));
			if(answer[i]<=0) answer[i] += 23*60+59;
			answer[i] -= fees[0];
			int fee = fees[1];
			if(answer[i] > 0) fee += Math.ceil((double)answer[i]/fees[2])*fees[3];
			answer[i] = fee;
		}

		return answer;
	}
}
