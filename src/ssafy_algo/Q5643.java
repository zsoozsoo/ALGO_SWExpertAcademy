package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5643 {
	
	static int[][] arr;
	static int[] gtCnt,ltCnt; //각 항생들보다 큰애들 저장해줄 배열, 작은애들 저장해줄 배열
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			arr = new int[n+1][n+1];
			gtCnt = new int[n+1];
			ltCnt = new int[n+1];
			
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}
			
			for (int i = 1; i <= n; i++) {
				dfs(new boolean[n+1],i,i);
			}
			
			int res = 0;
			for (int i = 1; i <= n; i++) {
				if(gtCnt[i]+ltCnt[i]==n-1) res++;
			}
			
			System.out.println("#"+tc+" "+res);
		}
	}
	
	public static void dfs(boolean[] vs, int idx, int start) {
		vs[idx] = true;
		
		for (int i = 1; i <= n; i++) {
			if(!vs[i] && arr[idx][i]==1) {
				gtCnt[start]++;
				ltCnt[i]++;
				dfs(vs,i,start);
			}
						
		}
	}
}
