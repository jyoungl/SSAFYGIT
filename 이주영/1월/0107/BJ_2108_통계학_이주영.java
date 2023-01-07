package jan07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BJ_2108_통계학_이주영 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 1;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			
			if(!map.containsKey(arr[i]))
				map.put(arr[i], 1);
			else {
				map.replace(arr[i], map.get(arr[i])+1);
				if(map.get(arr[i]) > max)
					max = map.get(arr[i]);
			}
		}
		
		Arrays.sort(arr);
		List<Integer> keylist = new ArrayList<>(map.keySet());
		Collections.sort(keylist);
		
		int cnt = 0;
		int ans = 0;
		for(Integer key : keylist) {
			int x = map.get(key);
			if(x == max) {
				ans = key;
				cnt++;
				
				if(cnt == 2)
					break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append((int)Math.round((double)sum/N)).append("\n");
		sb.append(arr[N/2]).append("\n");
		sb.append(ans).append("\n");
		sb.append(arr[N-1] - arr[0]);
		System.out.println(sb);
	}

}
