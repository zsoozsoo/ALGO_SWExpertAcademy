package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4012 {
	
	static int N, min;
	static int[][] food;
	static int[] left, right;
	static boolean[] isSelected;
	
	public static void cal(int[] left, int[] right) {
		int synL = 0, synR=0;
		for (int i = 0; i <N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				synL += food[left[i]][left[j]];
				synR += food[right[i]][right[j]];
			}
		}
			int syn = Math.abs(synL-synR);
			if(syn<min) min = syn;
	}
	
	public static void combination(int idx, int toSelect) {
				
		if(toSelect == N/2) {
			int num = 0;
			for (int i = 0; i < N; i++) {
				if(!isSelected[i]) right[num++] = i+1;
			}
			cal(left,right);
			return;
		}
			if(idx==N) return;
			isSelected[idx] = true;
			left[toSelect] = idx+1;
			combination(idx+1,toSelect+1);
			isSelected[idx] = false;
			combination(idx+1,toSelect);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			food = new int[N+1][N+1];
			isSelected = new boolean[N];
			left = new int[N/2]; right = new int[N/2];
			
			for (int i = 1; i < N+1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N+1; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = 999999999;
			combination(0,0);
			System.out.println("#"+(t+1)+" "+min);
		}
		
	}
}
