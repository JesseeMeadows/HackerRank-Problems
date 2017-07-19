import java.util.Scanner;

public class FlippingTheMatrix {
	public static void main (String args[] ) throws Exception {
		Scanner in = new Scanner(System.in);
		int Q = in.nextInt();
		
		for (int q = 0; q < Q; q++) {
			in.nextLine();
			int N = in.nextInt();
			int[][] matrix = new int[2 * N][2 * N];
			for (int i = 0; i < 2 * N; i++) {
				in.nextLine();
				for (int j = 0; j < 2 * N; j++) {
					matrix[i][j] = in.nextInt();
				}
			}
			
			int total = 0;
			for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				int topLeft  = matrix[i][j];
				int topRight = matrix[i][(2 * N) - (j + 1)]; 
				int bottomLeft = matrix[(2 * N) - (i + 1)][j]; 
				int bottomRight = matrix[(2 * N) - (i + 1)][(2 * N) - (j + 1)];
				
				if (topLeft < topRight)    topLeft = topRight;
				if (topLeft < bottomLeft)  topLeft = bottomLeft;
				if (topLeft < bottomRight) topLeft = bottomRight;
				
				total += topLeft;
			}
			System.out.println(total);
		}
	}
}
