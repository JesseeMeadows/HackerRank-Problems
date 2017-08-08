import java.util.Scanner;

/* Problem: "Connected Cells in a Grid"
  * 	url: https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
  * 
  * 	Thoughts:
  * 		We could iterate through the grid and when we come across a '1' we find 
  * 		and count all cells in the connected component(keeping a max CC size).
  * 		We would then continue from where we initially found the first cell of  
  * 		the CC and do the same thing for the next CC we come across
  */
public class ConnectedCellsInAGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in); 
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] g = new int[n][m];
		int max = 0;
		
		for (int r = 0; r < n; r++) {
			in.nextLine();
			for (int c = 0; c < m; c++) {
				g[r][c] = in.nextInt();
			}
		}
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (g[r][c] == 1) {
					int count = countRegion(g, r, c);
					max = Math.max(max, count);
				}
			}
		}
		
		System.out.println(max);
		
	}
	
	public static int countRegion(int[][] g, int r, int c) {
		g[r][c] = 2;
		int count = 1;
		
		if (r > 0) {
			// UP
			if (g[r - 1][c] == 1) count += countRegion(g, r - 1, c);
			
			// Up-Left
			if (c > 0 && g[r - 1][c - 1] == 1) count += countRegion(g, r - 1, c - 1);
			
			// Up-Right
			if (c < g[0].length - 1 && g[r - 1][c + 1] == 1) count += countRegion(g, r - 1, c + 1);
		}
		
		if (r < g.length - 1) {
			// Down
			if (g[r + 1][c] == 1) count += countRegion(g, r + 1, c);
			
			// Down-Left
			if (c > 0 && g[r + 1][c - 1] == 1) count += countRegion(g, r + 1, c - 1);
			
			// Down-Right
			if (c < g[0].length - 1 && g[r + 1][c + 1] == 1) count += countRegion(g, r + 1, c + 1);
		}
		
		// Right
		if (c < g[0].length - 1 && g[r][c + 1] == 1) count += countRegion(g, r, c + 1);
		
		// Left
		if (c > 0 && g[r][c - 1] == 1) count += countRegion(g, r, c - 1);
		
		return count;
	}

}
