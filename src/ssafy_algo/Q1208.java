package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1208 {
	
	public static void dump(int[] arr) {
		Arrays.sort(arr);
		arr[0] += 1;
		arr[99] -= 1;
		Arrays.sort(arr);
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[100]; //각 높이들을 담아줄 배열
		
		for (int i = 0; i < 10; i++) {
			
			int cnt = 0; //100번 돌아가는거 확인해주는 변수
			int  N = Integer.parseInt(br.readLine()); //덤프횟수
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) { //각 높이모아줄 배열에 높이 하나씩 넣어주기
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			while(true) {
				dump(arr); cnt++;
				if(cnt==N) break;
			}
			
			System.out.println("#"+(i+1) + " " + (arr[99]-arr[0]));
		}

	}

}
