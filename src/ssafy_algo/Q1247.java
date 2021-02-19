package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1247 {
	
	public static int distance(int[][] arr1,  int idx1, int[][] arr2 , int idx2) {
		 return Math.abs(arr1[idx1][0]-arr2[idx2][0]) + Math.abs(arr1[idx1][1]-arr2[idx2][1]) ;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] home = new int[1][2];
			int[][] office = new int[1][2];
			int[][] map = new int[N][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			home[0][0] = Integer.parseInt(st.nextToken()); home[0][1] = Integer.parseInt(st.nextToken());
			office[0][0] = Integer.parseInt(st.nextToken()); office[0][1] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
					map[i][0] = Integer.parseInt(st.nextToken());
					map[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(map, Comparator.comparingInt(o->o[0]));
			
			for (int i = 0; i < N-1; i++) {
				if(office[0][0]>=map[i][0] && office[0][0] <= map[i+1][0]) {
					Math.min(distance(home,0,map,i), distance(home,0,map,i));
				}
			}
			
			
		}
		
	}
}
