package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q6808 {
	
	static int[] firstArr;
	static int[] secondArr;
	static boolean[] allNum;
	
	public static void makePermutation(int toSelect, int[] selected,int[] selected2, boolean[] visited) {
		
		for (int i = 1; i < 19; i++) {
			if(!allNum[i]) {
				allNum[i] = true;
				int score = firstArr[toSelect] + i;
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			allNum = new boolean[19];
			firstArr = new int[9];
			secondArr = new int[9];
			
			for (int j = 0; j <9; j++) {
				int num = Integer.parseInt(st.nextToken());
				allNum[num] = true;
				firstArr[j] = num;
			}
			
			int cnt = 0;
			for (int j = 1; j <= 18; j++) {
					if(allNum[j]==false) { 
						secondArr[cnt] = j; cnt++;
					}
			}
			
			makePermutation(0,new int[9],new int[9],new boolean[9]);
			
		}
	}
}
