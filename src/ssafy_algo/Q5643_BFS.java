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

public class Q5643_BFS {
	
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
				gBFS(i, new boolean[n+1]);
				lBFS(i, new boolean[n+1]);
				if(gtCnt + ltCnt == n-1) ++res;
			}
			
			System.out.println("#"+tc+" "+res);
			
			
		}
	}
	
	static void gBFS(int start, boolean[] vs) { //큰애들
			Queue<Integer> queue = new LinkedList<>();
			queue.add(start);
			vs[start] = true;
			
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				
				for (int i = 1; i <= n; i++) {
					if(!vs[i] && arr[curr][i]==1) {
						queue.offer(i);
						vs[i] = true;
						gtCnt++;
					}
				}
					
			}
		
	}
	
	static void lBFS(int start, boolean[] vs) { //큰애들
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		vs[start] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (int i = 1; i <= n; i++) {
				if(!vs[i] && arr[i][curr]==1) {
					queue.offer(i);
					vs[i] = true;
					ltCnt++;
				}
			}
				
		}
	
}
}
