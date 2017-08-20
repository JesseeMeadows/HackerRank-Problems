import java.util.Scanner;

/*	Problem: "Cipher"
 * 		url: https://www.hackerrank.com/challenges/cipher/problem
 * 
 * 		Thoughts: We know the first bit in the cipher is never altered because a shift would place a zero in it's column
 * 				  and xoring a zero will return the original number. Using this first digit, we can decipher the rest of the
 * 				  string. Since there's k shifts that take place, we only need to look at the previous k-bits. Since were deciphering
 * 				  the text left-to-right, we'll know those bits. With the previous k-bits and the bit in the cipher we'll be able to 
 * 				  deduct the original bit.
 * 					
 * 				 for a given bit ctb(cryptic-text bit): 
 * 					if ctb is '1' 
 * 						flip bit if number of 1-bits in previous k-bits is odd
 * 					else (ctb is 0)
 * 						flip bit if number of 1-bits in previous k-bits is even
 * 				
 * 				truncate the last k-bits

 */
public class Cipher {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int K = in.nextInt();
		in.nextLine();
		String s = in.nextLine();
		
		if (K == 1) {
			System.out.println(s);
			return;
		}
		
		char[] result = s.toCharArray();
		// Leftmost bit is same in both plain text and the cipher
		for (int i = 1; i < K; i++) {
			result[i] = xor(s.charAt(i), s.charAt(i-1));
		}
		for (int i = K; i < N; i++) {
			result[i] = xor(result[i], xor(s.charAt(i-1), result[i-K]));
		}
		for (int i = 0; i < N; i++) {
			System.out.print(result[i]);
		}
	}
	
	public static char xor(char a, char b) {
		if (a != b) return '1';
		else {
			return '0';
		}
	}
}

