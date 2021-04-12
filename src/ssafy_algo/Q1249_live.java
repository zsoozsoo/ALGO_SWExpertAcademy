package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1249_live {
	
	static int N, INF = Integer.MAX_VALUE; // 2차원의 크기 배열, 무한대
	static int map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}
			
			System.out.println("#"+t+" "+dijkstra(0,0));
			
		}
		
		
	}

	private static int dijkstra(int startR, int startC) {
		
		boolean[][] vs = new boolean[N][N]; //방문체크해주는 배열
		int[][] minTime = new int[N][N]; //최소시간
		
		//일단 무한대로 초기화 다 시켜줘야함
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}
		
		//1.일단 출발지는 0으로 해줌 ( 자기자신에서 자기자신으로 가는건 최소비용이 없으니까 )
		minTime[startR][startC] = 0;
		
		int r = 0, c= 0, cost = 0, nr, nc;
		//2.종점까지 갈때까지 무한루프 돌리기
		while(true) { //방문하지 않은 정점 중 출발지에서 자신으로 오는 비용이 최소인 정점 선택
			cost =INF; //무한대로 일단 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!vs[i][j] && cost > minTime[i][j]) { //방문하지 않은 애들 중 자기 자신으로 오는 애들이 최소인 애들일때
						cost = minTime[i][j];
						r = i; c = j; //최소 비용과 그때 행과열 기억
					}
				}
			}
			
			vs[r][c] = true; //방문했으니까
			if(r==N-1 && c==N-1) return cost; //종점에 도착
		
			
			//3.선택된 정점기준으로 인접한 정점 중 방문하지 않은 나머지 정점들, 자신과의 경유시의 비용과 기준 
			//  최소비용 비교하여 최소값 업데이트 ( 지금은 인접행렬 아니니까 4방 탐색 통해서 )
			
			//현재 정점 위치 기준으로 4방의 인접정점을 처리
			for (int i = 0; i <4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc <N && !vs[nr][nc] && minTime[nr][nc] > cost+map[nr][nc]){
					minTime[nr][nc] = cost+map[nr][nc];
				}
				
			}
			
		}
		
	}
}
