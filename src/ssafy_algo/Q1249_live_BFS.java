package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1249_live_BFS {

	private static int[][] map,minTime;
	private static int N, INF=Integer.MAX_VALUE;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for(int t=1; t<=TC; ++t) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			minTime = new int[N][N]; // 각 위치까지의 최소시간저장 목적, 너비가 크지만 시간이 더 최소면 같은 자리 또 지나감.
									 // 너비가 같거나 크며 시간이 더 걸리면 해당 자리 지나가지 않음.(가지치기 효과) 
			
			for(int i=0; i<N; ++i) {
				char[] ch = in.readLine().toCharArray();
				for(int j=0; j<N; ++j) {
					map[i][j] = ch[j] - '0';
					minTime[i][j] = INF;
				}
			}
			System.out.println("#"+t+" "+moveBFS(0,0));
		}
	}
	private static int moveBFS(int startR,int startC) {
		int recoveryTime=INF;
		Queue<int[]> queue = new LinkedList<int[]>();
		
		minTime[startR][startC]=0;
		queue.offer(new int[] {startR,startC});

		int r,c,nr,nc,current[];
		while(!queue.isEmpty()) {
			current = queue.poll();
			r = current[0];
			c = current[1];
			
			if(r==N-1 && c==N-1) {
				// 먼저 처리된 경로의 최소시간보다 더 작다면 최소값 갱신 
				if(minTime[r][c]<recoveryTime) recoveryTime = minTime[r][c];
				continue;
			}
			
			for(int d=0; d<4; ++d) { 
				nr = r + dr[d];
				nc = c + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N 
						&& minTime[r][c]+map[nr][nc] < minTime[nr][nc]) {
					minTime[nr][nc] = minTime[r][c]+map[nr][nc];
					queue.offer(new int[] {nr,nc});
				}
			}			
		}
		return recoveryTime;
	}//end method move
}
