import java.io.*;
import java.util.*;
public class BOJ_14719_빗물 {
	public static void main(String[] args) throws IOException {
		//현재 위치가 가장 크다고 가정하고
		//내 뒤에 나보다 더 큰 기둥이 있을 때, 내기둥-다른기둥들 전부 더하기. 큰기둥 직전까지
		//내 뒤에 나보다 더 큰 기둥이 없다면 나 다음으로 가장 큰 기둥(2기둥)을 찾고 2기둥높이-다른 기둥들 전부 더하기. 2기둥 직전까지.

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] blocks = new int[W];
		st=  new StringTokenizer(in.readLine());
		for(int i=0;i<W;i++) blocks[i] = Integer.parseInt(st.nextToken());

		int answer = 0;
		for(int i=0;i<W;){
			if(blocks[i]==0) {
				i++;
				continue;
			}
			int j=i+1;//나보다 큰 기둥
			int nj = j;//나 다음으로 큰 기둥
			int tmp = 0;
			for(;j<W;j++){
				if(blocks[i]<=blocks[j]) break;
				if(blocks[nj]<blocks[j]) nj = j;
				tmp += blocks[i]-blocks[j];
			}
			if(j<W){
				//같거나 더 큰 기둥 발견
				i=j;
			}
			else if(nj==W) {
				break;
			}
			else {
				//내가 가장 큰 기둥->나 다음으로 큰 기둥 활용(nj)
				tmp = 0;
				for(int k=nj-1;k>i;k--){
					tmp+=blocks[nj]-blocks[k];
				}
				i=nj;
			}

			answer+=tmp;
		}
		System.out.println(answer);

	}
}
