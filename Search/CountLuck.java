import java.util.Scanner;

/*  Problem: "Count Luck"
 * 		url: https://www.hackerrank.com/challenges/count-luck/problem
 * 		
 * 		Thoughts: we can treat the matrix as a graph, locations bordered by
 * 			      2 or more open spaces will be treated as vertices
 * 				 - we'll use dfs to traverse the open paths, while keeping track
 * 				   of the amount of vertices we come across on the given path
 * 				 - while traversing, we'll mark areas  already visited as "blocked"
 * 				   or 'X'
 */
public class CountLuck {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for (int t = 0; t < T; t++) {
			in.nextLine();
			int N = in.nextInt();
			int M = in.nextInt();
			in.nextLine();
			
			int startR = 0;
			int startC = 0;
			
			char[][] g = new char[N][M];
			
			for (int r = 0; r < N; r++) {
				String line = in.nextLine();
				for (int c = 0; c < M; c++) {
					g[r][c] = line.charAt(c);
					if (g[r][c] == 'M') {
						startR = r;
						startC = c;
					}
				}
			}

			int K = in.nextInt();
			
			int count = dfs(g, startR, startC);
			if (count == K) {
				System.out.println("Impressed");
			} else {
				System.out.println("Oops!");
			}
			
			
		}

	}
	
	public static int dfs(char[][] g, int r, int c) {
		if (g[r][c] == '*') {
			return 0;
		}
			
		g[r][c] = 'X';
		int paths = 0;
		boolean up = false;
	    boolean down = false;
	    boolean left =false;
		boolean right = false;
		
		if (r > 0 && g[r-1][c] != 'X') {
			paths++;
			up = true;
		}
		if (r < g.length - 1 && g[r+1][c] != 'X') {
			paths++;
			down = true;
		}
		if (c > 0 && g[r][c - 1] != 'X') {
			paths++;
			left = true;
		}
		if (c < g[0].length - 1 && g[r][c + 1] != 'X') {
			paths++;
			right = true;
		}
		
		if (paths == 0) {
			return -1;
		}
		else if (paths == 1) {
			if (up) 		return dfs(g, r-1, c);
			else if (down)  return dfs(g, r+1, c);
			else if (left)  return dfs(g, r, c-1);
			else 			return dfs(g, r, c+1);
		} else {
			int result = -1;
			if (up) {
				result = dfs(g, r-1, c);
				if (result != -1) return 1 + result;
			}
			if (down) {
				result = dfs(g, r+1, c);
				if (result != -1) return 1 + result;
			}
			if (left) {
				result = dfs(g, r, c-1);
				if (result != -1) return 1 + result;
			}
			if (right) {
				result = dfs(g, r, c+1);
				if (result != -1) return 1 + result;
			}
			
			return -1;
		}
		
	}

}
