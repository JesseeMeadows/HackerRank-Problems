import java.util.Scanner;

/*	Problem: "Counter Game"
 * 		url: https://www.hackerrank.com/challenges/counter-game/problem
 * 		
 * 		Thoughts: if an integer is a power of 2 then subtracting 1 from the number
 * 				  will result in 1-bits in all prior bits. Since a number that's a power of 2
 * 				  contains a single 1-bit, 'and' a power of 2 number with itself minus one will only
 * 				  produce 0 as an answer. This ensures there's only a single 1-bit in the number. So 
 * 				  we can simply simulate the game and find the winner
 * 
 */	
public class CounterGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int T = Integer.parseInt(in.nextLine());
		
		for (int t = 0; t < T; t++) {
			long n = Long.parseLong(in.nextLine());
			boolean louise = true;
			while (n != 1L) {
				// halve if n is a power of 2
				if ((n ^ (n - 1L)) == 0L) {
					n = (n >> 1);
				} else {
					Long delta = 1L;
					while (delta < n) {
						delta = (delta << 1);
					}
					n = n - (delta >> 1);
				}
				louise = !louise;
			}
			if (louise) {
				System.out.println("Richard");
			} else {
				System.out.println("Louise");
			}
		}

	}

}