package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 1. 난쟁이 9명
 * 2. 키의 합은 100
 * 3. 전부 더한 뒤 두 명을 더해서 뺀 값이 100이면 출력
 * 4. 출력은 오름차순
 */
public class b2_2309_일곱난쟁이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sum = 0;
		int fake = 0;
		int result = 0;
		int iNum = 0;
		int jNum = 0;
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		} //배열에 키 저장
		
		for(int i = 0; i < 8; i++) {
			for(int j = i+1; j < 9; j++) {
				sum -= arr[i] + arr[j]; //9명 키의 합에서 두 명의 키를 뺀다
				if(sum==100) { //7명 키의 합이 100일 때
					iNum = arr[i]; 
					jNum = arr[j];
					break;
					//두 명의 키 저장 뒤 break
				}
				sum += arr[i] + arr[j]; //100이 아닐 때 다시 복구한 뒤 for 돌림
			}
		}
		
		Arrays.sort(arr); //오름차순 정렬
		
		for(int i = 0; i < 9; i++) {
			if(arr[i] != iNum && arr[i] != jNum) System.out.println(arr[i]); //저장된 두 명의 키와 다를 때 출력
		}	
	}
}
