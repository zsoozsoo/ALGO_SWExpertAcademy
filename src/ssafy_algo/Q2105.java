package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2105 {
	
	static int[][] dir = {{-1,-1},{1,-1},{1,1},{-1,1}};
	static int[][] arr;
	static boolean[][] visited;
	static List<Integer> list;
	static int N, cnt, result = 0, x, y;
	
	static void desert(int dx, int dy, int idx) {
		
		for (int i = 0; i < 4; i++) {
			
			int row = dx + dir[i][0];
			int col = dy + dir[i][1];
			
			if(row >=0 && row < N && col >= 0 && col < N) {
				if(row == x && col == y) {
					cnt = list.size();
					result = Math.max(result, cnt);
					return;
				}
				
				if(!visited[row][col]) {
					visited[row][col] = true;
					list.add(arr[row][col]);
					desert(row,col,i);
					list.remove(arr[row][col]);
					visited[row][col] = false;
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t <T; t++) {
			N = Integer.parseInt(br.readLine());
			result = -1;
			
			visited = new boolean[N][N];
			arr = new int[N][N];
			list = new ArrayList<>();
			
			for (int i = 0; i <N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N-2; i++) {
				for (int j = 0; j < N-1; j++) {
					x = i; y=j;
					visited[i][j] = true;
					desert(i,j,0);
					visited[i][j] = false;
				}
			}
			
			System.out.println(result);
			
		}
	}
}
