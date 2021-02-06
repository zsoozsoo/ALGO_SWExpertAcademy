package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1873 {

    static int row = 0, col = 0;
    static int H = 0, W = 0;

    public static void move(char[][] arr,char c){
        switch (c){ //이동하는 방향에 따라 움직이게 하기
            case 'U' :
                if(row-1>=0 && arr[row-1][col]=='.') {
                    arr[row][col] = '.'; arr[row-1][col] = '^';
                    row -= 1;
                }else {
                    arr[row][col] = '^'; return;
                } break;
            case 'D' :
                if(row+1<H && arr[row+1][col]=='.') {
                    arr[row][col] = '.'; arr[row+1][col] = 'v';
                    row += 1;
                }else {
                    arr[row][col] = 'v'; return;
                }break;
            case 'L' :
                if(col-1>=0 && arr[row][col-1]=='.') {
                    arr[row][col] = '.'; arr[row][col-1] = '<';
                    col -= 1;
                }else {
                    arr[row][col] = '<';
                    return;
                } break;
            case 'R' :
                if(col+1<W && arr[row][col+1]=='.') {
                    arr[row][col] = '.'; arr[row][col+1] = '>';
                    col += 1;
                }else {
                    arr[row][col] = '>';
                    return;
                } break;
            case 'S' : shoot(arr[row][col],arr); break; //shoot하면 shoot()메소드로 넘어가도록 하기
        }
    }

    public static void shoot(char c, char[][] arr){
        switch (c){ //방향과 앞에 장애물에 다르게 각각 실행되도록 메소드 구성
            case '^' :
                for (int i = row; i >=0; i--) {
                    if(arr[i][col]=='#') return;
                    else if (arr[i][col]=='*'){
                        arr[i][col] ='.';
                        return;
                    }
                } break;
            case 'v' :
                for (int i = row; i <H; i++) {
                    if(arr[i][col]=='#') return;
                    else if (arr[i][col]=='*'){
                        arr[i][col] ='.';
                        return;
                    }
                } break;
            case '<' :
                for (int i = col; i >=0; i--) {
                    if(arr[row][i]=='#')  return;
                    else if (arr[row][i]=='*'){
                        arr[row][i] ='.';
                        return;
                    }
                } break;
            case '>' :
                for (int i = col; i <W; i++) {
                    if(arr[row][i]=='#') return;
                    else if (arr[row][i]=='*'){
                        arr[row][i] ='.';
                        return;
                    }
                } break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트케이스

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); //높이
            W = Integer.parseInt(st.nextToken()); //넓이

            char[][] arr = new char[H][W]; //게임 맵 입력받기
            for (int h = 0; h < H; h++) {
                String s = br.readLine();
                for (int w = 0; w < W; w++) {
                    arr[h][w] = s.charAt(w);
                    if (arr[h][w] == '<' || arr[h][w] == '>' || arr[h][w] == '^' || arr[h][w] == 'v') {
                        row = h;
                        col = w;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            char[] dir = new char[N];
            String s2 = br.readLine();

            for (int i = 0; i < N; i++) { //사용자가 넣는 입력 배열에 받기
                dir[i] = s2.charAt(i);
            }

            for (int i = 0; i < N; i++) { //이동시켜주기
                move(arr, dir[i]);
            }

            System.out.print("#"+(tc+1)+" "); //출력문
            for (int h = 0; h < H; h++) {
                for (int w = 0; w < W; w++) {
                    System.out.print(arr[h][w]);
                }
                System.out.println();
            }
        }
    }
}
