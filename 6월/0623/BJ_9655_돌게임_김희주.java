import java.io.*;

public class BOJ_9655_돌게임 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		if(N/3%2 != N%3%2) System.out.println("SK");
		else System.out.println("CY");
	}
}
