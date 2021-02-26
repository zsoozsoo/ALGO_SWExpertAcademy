package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1767 {

	static int N,max,totalCnt,min,map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static ArrayList<int[]> list; //고려해야하는 코어만 담고 있는 리스트 ( 가장자리는 빼기)
	
	private static void go(int index,int cCnt) { // index : 부분집합에 고려할 코어 인덱스 , cCnt : 연결된 코어 개수
		
		if(index == totalCnt) {
			int res = getLength(); //놓아진 전선의 길이 구해야함
			if(max<cCnt) {
				max = cCnt;
				min = res;
			}else if(max==cCnt) {
				if(res<min) min = res;
			}
			
			return;
		}
		
		//코어 선택해서 전선 놓아보기(4방향으로 놓아봐야함)
		int[] cur = list.get(index);
		int r = cur[0]; // 행
		int c = cur[1]; // 열
		for (int i = 0; i < 4; i++) { //사방향 어디어디 가능한지 보기
			if(isAvailable(r,c,i)) {
				//전선놓기 + 다음코어로 넘어가기
				go(index+1,cCnt+1); 
				//놓았던 전선 되돌려 놓기
				setStataus(r,c,i,0);
			}
		}
		
		//코어 비선택
		go(index+1,cCnt);
	}
	
	private static void setStataus(int r, int c, int d, int s) {
		int nr = r, nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0 || nr>=N || nc<0 || nc<=N) break;
			map[nr][nc] = s;
		}
	}
	
	// 0:빈칸 , 1:코어 존재, 2:전선설치 ( 즉 2,3은 연결 불가능 )
	private static boolean isAvailable(int r, int c, int d) { //끝까지 나아갈 수 있는지 확인하는 메소드
		int nr = r, nc = c;
		while(true) {
			nc += dr[d];
			nc += dc[d];
			if(nc<0 || nr>=N || nc<0 || nc>=N) break; //끝까지 갔다는 얘기 == 연결됐다는 의미 >> 게속해서 해당방향으로 직진을 해서 경계를 벗어남
			if(map[nr][nc]>=1) return false; // 1,2는 둘 다 어쨋든 연결이 불가능한거니까 
		}
		
		return true;
	}
	
	private static int getLength() {
		int lCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 2) lCnt++;
			}
		}
		
		return lCnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j <N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i==0 || j==0 || i==N-1 || j==N-1) continue; //가장자리는 무시
					if(map[i][j]==1) {
						list.add(new int[] {i,j});
						totalCnt++;
					}
				}
			}
			
			go(0,0);
		}
	}
	
}
