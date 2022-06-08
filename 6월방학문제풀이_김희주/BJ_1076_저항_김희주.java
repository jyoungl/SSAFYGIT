import java.io.*;
import java.util.*;

//타입체크 필수
public class BOJ_1076_저항 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Map<String,Integer> map = new HashMap<>();
		map.put("black",0);
		map.put("brown",1);
		map.put("red",2);
		map.put("orange",3);
		map.put("yellow",4);
		map.put("green",5);
		map.put("blue",6);
		map.put("violet",7);
		map.put("grey",8);
		map.put("white",9);

		long num = map.get(in.readLine())*10+map.get(in.readLine());
		num *= Math.pow(10,map.get(in.readLine()));

		System.out.println(num);
	}
}
