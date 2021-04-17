package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1953 {
	static int[][] map;
	static int exit = 0,r,c;
		
	public static class pos{
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
			r = Integer.parseInt(st.nextToken()); //세로크기
			c = Integer.parseInt(st.nextToken()); //가로크기
			int coverR = Integer.parseInt(st.nextToken()); //맨홀 뚜껑 위치 세로
			int coverC = Integer.parseInt(st.nextToken()); //맨홀 뚜껑 위치 세로
			int time = Integer.parseInt(st.nextToken()); //소요된 시간
			
			map = new int[r][c];
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); //지도 채워주기
				}
			}
			
			bfs(coverR,coverC,time);
			System.out.println("#"+tc+" "+exit);
		}
	}

	private static void bfs(int coverR, int coverC, int time) {
		int depth = 0;
		exit = 0;
		//System.out.println(coverR+" "+coverC+" "+time);
		Queue<pos> queue = new LinkedList<pos>();
		boolean[][] vs = new boolean[r][c];
		queue.add(new pos(coverR,coverC));
		vs[coverR][coverC] = true;
		exit++;
		
		while(!queue.isEmpty()) {
			if(depth==time-1) break;
				for (int i = queue.size(); i >0; i--) {
					pos curr = queue.poll();
					int oriR = curr.row;
					int oriC = curr.col;
					
					List<pos> dir = dir(map[oriR][oriC]);
					
					for (int j = 0; j <dir.size(); j++) {
						int availR = oriR+dir.get(j).row;
						int availC = oriC+dir.get(j).col;
						
						if(availR>=0 && availR <r && availC>=0 && availC <c && !vs[availR][availC] && map[availR][availC]>0 && check(dir,j,map[availR][availC])) {
							exit++;
							queue.add(new pos(availR,availC));
							vs[availR][availC] = true;
						}
					}
				}
			depth++;
			
		}
		
		
	}
	
	private static boolean check(List<pos> dir, int idx, int num) {
		int checkR = dir.get(idx).row;
		int checkC = dir.get(idx).col;
		
		if(num== 1) return true;
		
		if(checkR==-1 || checkR == 1) {
			if(num==2) return true;
			if(checkR == -1) if(num==5 || num==6) return true;
			if(checkR == 1) if(num==4 || num==7) return true;
		}else {
			if(num==3) return true;
			if(checkC == -1) if(num==4 || num==5) return true;
			if(checkC == 1) if(num==6 || num==7) return true;
		}
		return false;
	}
	
	private static List<pos> dir(int num) {
		List<pos> list = new ArrayList<>();
		
		switch(num) {
		case 1: list.add(new pos(-1,0)); list.add(new pos(1,0)); list.add(new pos(0,-1)); list.add(new pos(0,1)); break;//상하좌우
		case 2: list.add(new pos(-1,0)); list.add(new pos(1,0)); break; //상하
		case 3: list.add(new pos(0,-1)); list.add(new pos(0,1)); break; //좌우
		case 4: list.add(new pos(-1,0)); list.add(new pos(0,1)); break; //상우
		case 5: list.add(new pos(1,0));  list.add(new pos(0,1)); break; //하우
		case 6: list.add(new pos(1,0));  list.add(new pos(0,-1)); break; //하좌
		case 7: list.add(new pos(-1,0)); list.add(new pos(0,-1)); break; //상좌
		}
		
		return list;
	}
}
