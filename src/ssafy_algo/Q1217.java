package ssafy_algo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q1217 {
	public static int pow(int x, int y) {
		if (y == 0)
			return 1;
		return x * pow(x, y - 1);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int test = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println("#" + t + " " + pow(x, y));
		}
	}
}
