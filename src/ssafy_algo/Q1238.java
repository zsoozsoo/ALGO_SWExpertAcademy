package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1238 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int stIdx = Integer.parseInt(st.nextToken());
			
			int[] visited = new int[cnt+1]; // 방문한 곳 체크할 배열
			int[][] arr = new int[101][101]; // 숫자들 저장해놓을 배열
			Queue <Integer> queue = new LinkedList<>(); // 큐이용한 연결리스트
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cnt/2; i++) { //숫자들 저장해놓기
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = 1;
			}
			
			queue.offer(stIdx);//시작점 부터 큐에 넣어서 체크
			visited[stIdx] = 1;			
			int seq = 0;
			
			//bfs
			while(!queue.isEmpty()) {
				int idx = queue.poll();
				seq = visited[idx];
				
				for (int i = 1; i <= 100; i++) {
					if(arr[idx][i] == 1 && visited[i]==0) {
						visited[i] = visited[idx]+1;
						queue.offer(i);
					}
				}
			}
			
			//최대값구하기
			int max = 0;
			for (int i = 1; i <= cnt; i++) {
				if(visited[i]==seq) {
					if(max < i) max = i;
				}
			}
			
			System.out.println("#"+t+" "+max);
			
		}
		
	}
}
