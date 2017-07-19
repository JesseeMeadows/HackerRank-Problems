import java.util.Scanner;

public class AlmostSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.nextLine();
		
		int[] a = new int[N];
		a[0] = in.nextInt();
		boolean descending = false;
		int[] ds = new int[4];
		int descSScount = -1;
		for (int n = 1; n < N; n++) {
			a[n] = in.nextInt();
			if (descending) {
				if (a[n] > a[n-1]) {
					ds[++descSScount] = n-1;
					descending = false;
				}
			} else {
				if (a[n] < a[n-1]) {
					if (descSScount == 4) {
						System.out.println("no");
						return;
					}
					descending = true;
					ds[++descSScount] = n-1;
					
				}
			}
		}
		
		if (descending) {
			ds[++descSScount] = a.length - 1;
		}
		
		if (descSScount == 4) {
			int temp = a[ds[0]];
			a[ds[0]] = a[ds[2]];
			a[ds[2]] = temp;
			
			for (int i = 1; i < a.length; i++) {
				if (a[i] < a[i-1]) {
					System.out.println("no");
					return;
				}
			}
			System.out.println("yes");
			System.out.println("swap " + ds[0] + " " + ds[2]);
			return;
		} else if (descSScount == 2) {
			if (ds[1] - ds[0] == 1) {
				System.out.println("yes");
				System.out.println("swap " + ds[0] + " " + ds[1]);
				return;
			} else if (ds[1] - ds[0] > 1) {
				if (a[ds[0]] < a[ds[1] + 1] && a[ds[1]] > a[ds[0] - 1]) {
					System.out.println("yes");
					System.out.println("reverse " + ds[0] + " " + ds[1]);
					return;
				}
			}
		}
		System.out.println("no");
		
		
	}

}
