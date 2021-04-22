package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5643_DFS { //그래프의 연결성은 dfs 더 간단
	
	static int[][] arr;
	static int n,gtCnt,ltCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int res = 0;
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine()); //학생들의 수
			int m = Integer.parseInt(br.readLine()); //두 학생의 키를 비교한 횟수
			
			arr = new int[n+1][n+1]; //인접행렬 생성
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}
			
			for (int i = 1; i <=n; i++) {
				gtCnt = ltCnt = 0;
				gDFS(i, new boolean[n+1]);
				lDFS(i, new boolean[n+1]);
				if(gtCnt + ltCnt == n-1) ++res;
			}
			
			System.out.println("#"+tc+" "+res);
			
			
		}
	}
	
	static void gDFS(int cur, boolean[] vs) { //큰애들
			vs[cur] = true;
				for (int i = 1; i <= n; i++) {
					if(!vs[i] && arr[cur][i]==1) {
						gDFS(i,vs);
						gtCnt++;
					}
					
			}
		
	}
	
	static void lDFS(int cur, boolean[] vs) { //큰애들
		vs[cur] = true;
			for (int i = 1; i <= n; i++) {
				if(!vs[i] && arr[i][cur]==1) {
					lDFS(i,vs);
					ltCnt++;
				}
				
		}
	
	}
}
