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

public class Q5643_Memorization { //큰것만 체크해주는 방식
	
	static int[][] arr;
	static int[] gtCnt,ltCnt; //각 항생들보다 큰애들 저장해줄 배열, 작은애들 저장해줄 배열
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int res = 0;
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine()); //학생들의 수
			int m = Integer.parseInt(br.readLine()); //두 학생의 키를 비교한 횟수
			
			arr = new int[n+1][n+1]; //인접행렬 생성
			gtCnt = new int[n+1];
			ltCnt = new int[n+1];
			
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b]  = 1;
			}
			
			for (int i = 1; i <=n; i++) {
				dfs(i, i,new boolean[n+1]);
			}
			
			for (int i = 1; i <=n; i++) {
				if(gtCnt[i]+ltCnt[i]==n-1)res++;
			}
			
			System.out.println("#"+tc+" "+res);
			
			
		}
	}
	
	static void dfs(int cur, int start, boolean[] vs) { //start > 출발지 확인 ( 출발은 안바뀌니까 고정 )
			vs[cur] = true;
				for (int i = 1; i <= n; i++) {
					if(!vs[i] && arr[cur][i]==1) {
						dfs(i,start,vs);
						gtCnt[start]++; //출발지에서 자기보다 큰애들 배열 하나 추가해주고
						ltCnt[i]++; //작은애들은 start가 작은거니까 하나 추가
					}
					
			}
		
	}
	

}
