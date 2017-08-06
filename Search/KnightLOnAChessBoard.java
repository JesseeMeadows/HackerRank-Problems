import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class KnightLOnAChessBoard {

	// Thoughts: we can use an algorithm similar to prims on each
	// KnightL combination
	// Basically:
	// 	Use a graph G consisting of all possible positions
	// 	perform a BFS from starting position (0,0) to all
	// reachable vertices, marking unvisited nodes as visited
	// and the amount of turns it took to find

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		int[][] distTo = new int[N - 1][N - 1];

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (distTo[i - 1][j - 1] == 0) {
					int movesToEnd = knightL(i, j, N);
					distTo[i - 1][j - 1] = movesToEnd;
					distTo[j - 1][i - 1] = movesToEnd;
				}
			}
		}

		// Print each position in distTo
		for (int r = 0; r < N - 1; r++) {
			for (int c = 0; c < N - 1; c++) {
				System.out.print(distTo[r][c] + " ");
			}
			System.out.println();
		}

	}

	public static int knightL(int a, int b, int N) {
		// Create NxN positions matrix "visited" to track if a position has been visited
		boolean[][] visited = new boolean[N][N];

		// track amount of moves via "moves"
		int moves = 0;

		// Create array "positions" to track newly visited nodes
		// Add our starting position (0,0) to "positions"
		Deque<Integer> s = new ArrayDeque<Integer>();
		s.push(0);
		s.push(0);
		while (!s.isEmpty()) {
			// create array "discovered" to hold all newly reachable nodes
			Deque<Integer> discovered = new ArrayDeque<Integer>();

			// For each p in "positions"
			while (!s.isEmpty()) {
				int x = s.pop();
				int y = s.pop();

				if (x == N - 1 && y == N - 1)
					return moves;

				if (visited[y][x] == false) {
					visited[y][x] = true;

					// add unvisited unreachable nodes from p to "discovered"
					if (x - a >= 0 && y - b >= 0 && !visited[y - b][x - a]) {
						discovered.push(y - b);
						discovered.push(x - a);
					}

					if (x - b >= 0 && y - a >= 0 && !visited[y - a][x - b]) {
						discovered.push(y - a);
						discovered.push(x - b);
					}

					if (x + a < N && y + b < N && !visited[y + b][x + a]) {
						discovered.push(y + b);
						discovered.push(x + a);
					}

					if (x + b < N && y + a < N && !visited[y + a][x + b]) {
						discovered.push(y + a);
						discovered.push(x + b);
					}

					if (x + a < N && y - b >= 0 && !visited[y - b][x + a]) {
						discovered.push(y - b);
						discovered.push(x + a);
					}

					if (x + b < N && y - a >= 0 && !visited[y - a][x + b]) {
						discovered.push(y - a);
						discovered.push(x + b);
					}

					if (x - a >= 0 && y + b < N && !visited[y + b][x - a]) {
						discovered.push(y + b);
						discovered.push(x - a);
					}

					if (x - b >= 0 && y + a < N && !visited[y + a][x - b]) {
						discovered.push(y + a);
						discovered.push(x - b);
					}

				}
			}

			// replace "positions" with "discovered"
			s = discovered;
			moves++;

		}
		return -1;
	}

}
