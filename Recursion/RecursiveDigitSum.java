import java.io.*;
import java.util.*;

public class RecursiveDigitSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String n = in.next();
		int k = in.nextInt();

		long c = 0;
		for (int i = 0; i < n.length(); i++) {
			c += (n.charAt(i) - '0');
		}
		c *= k;
		System.out.println(superDigit(c));
	}

	public static long superDigit(long i) {
		long count = 0;
		long t = i;
		while (t > 0) {
			count += t % 10;
			t = t / 10;
		}
		if (count < 10)
			return count;
		else
			return superDigit(count);

	}
}
