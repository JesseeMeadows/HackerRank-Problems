import java.util.Arrays;
import java.util.Scanner;

public class BearAndSteadyGene {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.nextLine();
		String inputString = in.nextLine();
		int[] s = new int[inputString.length()];
		final int A = 0, C = 1, T = 2, G = 3;
		final int STEADY = N/4;
		
		// Compute letter frequencies
		int[] sFreq = new int[4];
		for (int n = 0; n < N; n++) {
			switch (inputString.charAt(n)) {
				case 'A': s[n] = A; 
						  sFreq[A]++; 
						  break;
				case 'C': s[n] = C; 
						  sFreq[C]++;
						  break;
				case 'T': s[n] = T; 
						  sFreq[T]++; 
						  break;
				case 'G': s[n] = G;
						  sFreq[G]++
						  ; break;
			}
		}
		
		// Compute amount of characters that will require a change
		// and the character that needs changed
		int[] charSurplus = new int[4];
		
		if (sFreq[A] > STEADY) {
			charSurplus[0] = sFreq[A] - STEADY;
		}
		if (sFreq[C] > STEADY) {
			charSurplus[1] = sFreq[C] - STEADY;
		}
		if (sFreq[T] > STEADY) {
			charSurplus[2] = sFreq[T] - STEADY;
		}
		if (sFreq[G] > STEADY) {
			charSurplus[3] = sFreq[G] - STEADY;
		}
		
		// compute total character surplus to find the minimum possible size 
		// of a substring that would balance the gene
		int ssSize = 0;
		for (int i = 0; i < 4; i++) ssSize += charSurplus[i];
		
		if (ssSize == 0) {
			System.out.println(0);
			return;
		}
		// Search for smallest substring that contains the minimum surplus
		// of each character
		int lo = ssSize;
		int hi;
		while (!balancePoss(s, charSurplus, ssSize)) {
			if (ssSize * 2 >= s.length) {
				ssSize = s.length;
				break;
			}
			ssSize = ssSize * 2;
		}
		hi = ssSize;
		
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (!balancePoss(s, charSurplus, mid)) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		
		System.out.println(hi);
		
	}
	
	// determines if a substring of size "size", that contains the minimum
	// surplus chars needed, exist in the String s
	public static boolean balancePoss(int[] s, int[] a, int size) {
		int[] ssFreq = getFreq(s, size);
		int i = 0;
		while (i + size < s.length) {
			if (ssFreq[0] < a[0] || ssFreq[1] < a[1] 
			||  ssFreq[2] < a[2] || ssFreq[3] < a[3]) {
				ssFreq[s[i]]--;
				ssFreq[s[i + size]]++;
				i++;
				continue;
			}
			return true;
		}
		return false;
	}
	
	// calculates character frequency
	public static int[] getFreq(int[] s, int size) {
		int[] a = new int[4];
		for (int i = 0; i < size; i++) {
			a[s[i]]++;
		}
		return a;
	}
	

}
