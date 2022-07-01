import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1076_저항 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String A = in.readLine();
		String B = in.readLine();
		String C = in.readLine();

		String temp = "";

		
		switch(A) {
		case "black":
			temp = temp+"0";
			break;
		case "brown":
			temp = temp+"1";
			break;
		case "red":
			temp = temp+"2";
			break;
		case "orange":
			temp = temp+"3";
			break;
		case "yellow":
			temp = temp+"4";
			break;
		case "green":
			temp = temp+"5";
			break;
		case "blue":
			temp = temp+"6";
			break;
		case "violet":
			temp = temp+"7";
			break;
		case "grey":
			temp = temp+"8";
			break;
		case "white":
			temp = temp+"9";
			break;
		}
		switch(B) {
		case "black":
			temp = temp+"0";
			break;
		case "brown":
			temp = temp+"1";
			break;
		case "red":
			temp = temp+"2";
			break;
		case "orange":
			temp = temp+"3";
			break;
		case "yellow":
			temp = temp+"4";
			break;
		case "green":
			temp = temp+"5";
			break;
		case "blue":
			temp = temp+"6";
			break;
		case "violet":
			temp = temp+"7";
			break;
		case "grey":
			temp = temp+"8";
			break;
		case "white":
			temp = temp+"9";
			break;
		}
		
		int mulnum = 0;
		
		switch(C) {
		case "black":
			mulnum = 1;
			break;
		case "brown":
			mulnum = 10;
			break;
		case "red":
			mulnum = 100;
			break;
		case "orange":
			mulnum = 1000;
			break;
		case "yellow":
			mulnum = 10000;
			break;
		case "green":
			mulnum = 100000;
			break;
		case "blue":
			mulnum = 1000000;
			break;
		case "violet":
			mulnum = 10000000;
			break;
		case "grey":
			mulnum = 100000000;
			break;
		case "white":
			mulnum = 1000000000;
			break;
		}		
		long answer = Long.parseLong(temp)*mulnum;
		
		
		System.out.println(answer);
		
	}
	
}
