package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7699 {
	
	static int r,c,max;
	static char[][] arr;
	static int[] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class pos{
		int row,col;

		public pos(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		
			arr = new char[r][c];
			for (int i = 0; i < r; i++) {
				//1차원 배열을 복사해서 통째로 받기
				arr[i] = br.readLine().toCharArray(); // "CAAB" => {'C','A','A','B'}
//				String str = br.readLine();
//				for (int j = 0; j < c; j++) {
//					arr[i][j] = str.charAt(j);
//				}
			}
			
			visited = new int['Z'+1]; //'A' 앞부분은 안씀
			
			max = 1; //한글자도 방문한거니까
			visited[arr[0][0]]++;
			dfs(0,0,0);
			System.out.println("#"+tc+" "+max);
			
			
		}
	}
	
	//step : 현재까지 진행한 칸수
	private static void dfs(int row, int col, int step) {
		if(max==26) return; //최대 방문할 수 있는 명물의 개수 >>어차피 최대값이니까~
		
		//if(r==R && c==C) 원래는 종점 기준을 해줘야하지만 ~ 여기는 그런건 아니니까
		if(max < step) {
			max = step;
		}
		
		for (int i = 0; i < 4; i++) {
			int moveR = row+dr[i];
			int moveC = col+dc[i];
			if(moveR>=0 && moveR<r && moveC>=0 && moveC<c && visited[arr[moveR][moveC]]==0) { //배열범위 & 방문 체크
				visited[arr[moveR][moveC]]++; //방문체크
				dfs(moveR,moveC,step+1); //1칸 움직였으니까
				visited[arr[moveR][moveC]]--; //방문체크 원복
			}
		}
	}
}
