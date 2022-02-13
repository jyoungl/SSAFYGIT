package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2564_경비원_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int store = Integer.parseInt(br.readLine());
		
		int[][] box = new int[store+1][2];
		for(int i=0; i<store+1; i++) {
			st = new StringTokenizer(br.readLine());
			box[i][0] = Integer.parseInt(st.nextToken());
			box[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		int direc = box[store][0]; //동근씨 좌표 x
		int num = box[store][1]; // y
		//북쪽
		if(direc == 1) {
			for(int i=0; i<store; i++) {
				if(box[i][0] == 1) {
					cnt += Math.abs(box[i][1] - num);
				}else if(box[i][0] == 2) {
					cnt += Math.min(height + box[i][1] + num, height + (width - box[i][1]) + (width - num));
				}else if(box[i][0] == 3) {
					cnt += box[i][1] + num;
				}else {
					cnt += (height - box[i][1]) + num;
				}
			}
		}
		//남
		else if(direc == 2){
			for(int i=0; i<store; i++) {
				if(box[i][0] == 1) {
					cnt += Math.min(height + box[i][1] + num, height + (width - box[i][1]) + (width - num));
				}else if(box[i][0] == 2) {
					cnt += Math.abs(box[i][1] - num);
				}else if(box[i][0] == 3) {
					cnt += (height - box[i][1]) + num;
				}else {
					cnt += (height - box[i][1]) + (width - num);
				}
			}
		}
		//서
		else if(direc == 3) {
			for(int i=0; i<store; i++) {
				if(box[i][0] == 1) {
					cnt += num + box[i][1];
				}else if(box[i][0] == 2) {
					cnt += (height - num) + box[i][1];
				}else if(box[i][0] == 3) {
					cnt += Math.abs(box[i][1] - num);
				}else {
					cnt += Math.min(width + box[i][1] + num, width + (height - box[i][1]) + (height - num));
				}
			}
		}
		//동
		else if(direc == 4) {
			for(int i=0; i<store; i++) {
				if(box[i][0] == 1) {
					cnt += num + (width - box[i][1]);
				}else if(box[i][0] == 2) {
					cnt += (height - num) + (width - box[i][1]);
				}else if(box[i][0] == 3) {
					cnt += Math.min(width + box[i][1] + num, width + (height - box[i][1]) + (height - num));
				}else {
					cnt += Math.abs(box[i][1] - num);
				}
			}
		}
		
		System.out.println(cnt);
	}

}