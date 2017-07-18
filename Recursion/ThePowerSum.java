import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import com.google.common.math.IntMath;

public class ThePowerSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int X = in.nextInt();
		in.nextLine();
		int N = in.nextInt();
		
		ArrayList<Integer> powers = new ArrayList<Integer>();
		powers.add(0);
		int i = 1;
		while (true) {
			int iToX = IntMath.pow(i, N);
			if (iToX <= X) {
				powers.add(iToX);
			} else {
				powers.add(iToX);
				break;
			}
			i++;
		}
		int[] iToX = new int[powers.size()];
		for (int index = 1; index < powers.size(); index++) {
			iToX[index] = powers.get(index);
		}
		System.out.println(solve(iToX, 1, X));
	}
	
	public static int solve(int[] p, int c, int r) {
		if (p[c] == r) {
			return 1;
		}
		if (p[c] > r) return 0;
		return solve(p, c+1, r - p[c]) + solve(p, c+1, r);
	}

}
