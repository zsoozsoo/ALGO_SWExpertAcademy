package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1210 {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			int t = Integer.parseInt(br.readLine());
			
			int[][] map = new int[100][100];
			int row = 0 , col = 0, dir =0;
			for (int j = 0; j < 100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < 100; j2++) {
					map[j][j2] = Integer.parseInt(st.nextToken());
					if(map[j][j2]==2) { row = j; col = j2; }
				}
			}
			
			while(row!=0) { //row가 0이되기전까지 계속 돌리기
				if(dir==0) {
					row--;
					if(col-1 >0 && map[row][col-1]==1) dir = 1; //왼쪽
					else if(col+1 <100 && map[row][col+1]==1) dir = 2; //오른쪽
				}else if(dir==1) { //왼쪽으로 가고있을 때
					col--;
					if(map[row-1][col]==1) dir=0;
				}else if(dir==2) { //오른쪽으로 가고있을 때
					col++;
					if(map[row-1][col]==1) dir=0;
				}
			}
			
			System.out.println("#"+t+" "+col);
		}
	}

}
