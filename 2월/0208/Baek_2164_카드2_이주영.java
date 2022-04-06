package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_2164 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=input;i++) {
			queue.add(i);
		}
		
		while(queue.size() > 1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		System.out.println(queue.poll());
	}
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		// TODO Auto-generated method stub
//		Queue<Integer> queue = new LinkedList<>();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int input = Integer.parseInt(br.readLine());
//		
//		for(int i=1;i<=input;i++) {
//			queue.add(i);
//		}
//		
//		while(true) {
//			queue.poll();
//			queue.add(queue.poll());
//			
//			if(queue.size() == 1) {
//				System.out.println(queue.peek());
//				break;
//			}
////			else {
////				queue.add(queue.poll());
////			}
//		}

	

}
