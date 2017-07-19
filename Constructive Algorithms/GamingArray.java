import java.util.Scanner;

public class GamingArray {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int G = in.nextInt();
		
		for (int g = 0; g < G; g++) {
			in.nextLine();
			int N = in.nextInt();
			in.nextLine();
			
			int[] maxToLeft = new int[N];
			int maxIndex = 0;
			int max = Integer.MIN_VALUE;
			for (int n = 0; n < N; n++) {
				int input = in.nextInt();
				if (input > max) {
					maxIndex = n;
					max = input; 
				}
				maxToLeft[n] = maxIndex;
			}
			
			if (N == 1) {
				System.out.println("BOB");
			} else {
				boolean bobsTurn = true;
				int lastMove = N - 1;
				
				while (lastMove != -1) {
					bobsTurn = !bobsTurn;
					lastMove = maxToLeft[lastMove] - 1;
				}
				
				if (bobsTurn) {
					System.out.println("ANDY");
				} else {
					System.out.println("BOB");
				}
			}
			
		}
	}
}
