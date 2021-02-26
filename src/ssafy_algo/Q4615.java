package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4615 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N+1][N+1];
			//1 흑돌 , 2 백돌
			//초기 셋팅
			arr[N/2][N/2] = 2; arr[(N/2)+1][(N/2)+1] = 2; 
			arr[N/2][(N/2)+1] = 1; arr[(N/2)+1][N/2] = 1;
			
		}
		
	}
}
