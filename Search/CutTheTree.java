import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Problem: "Cut the Tree"
  * 	url: https://www.hackerrank.com/challenges/cut-the-tree/problem
  * 	
  * 	Thoughts: Since we're only making 1 cut in the problem we can simply
  * 			  sum up all the numbers while creating the tree. Then we 
  * 			  iterate up the tree while computing the differences with
  * 			  and without a given tree. d(u,v) will  be computed via
  * 			  total - 2* data(u). Since there's no real ordering defined,
  * 			  we'll recursively traverse the tree and begin on leafs.
  */
public class CutTheTree {
	public int value;
	public ArrayList<Integer> adj;
	
	public CutTheTree(int value) {
		this.value = value;
		adj = new ArrayList<Integer>();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		
		List<CutTheTree> g = new ArrayList<CutTheTree>(n + 1);
		g.add(new CutTheTree(0));
		
		int total = 0;
		
		for (int i = 0; i < n; i++) {
			int input = in.nextInt();
			total += input;
			g.add(new CutTheTree(input));
		}
		
		for (int i = 1; i < n; i++) {
			in.nextLine();
			int u = in.nextInt();
			int v = in.nextInt();
			g.get(u).adj.add(v);
			g.get(v).adj.add(u);
		}
		
		System.out.println(dfs(g, 1, -1, total));
		
	}
	
	public static int dfs(List<CutTheTree> g, int v, int prev, int total) {
		int min = Integer.MAX_VALUE;
		for (Integer x: g.get(v).adj) {
			if (x != prev) {
				int result = dfs(g, x, v, total);
				if (result < min) {
					min = result;
				}
				g.get(v).value += g.get(x).value;
			}
		}
		int dUV = total - 2* g.get(v).value;
		if (dUV < 0) {
			dUV *= -1;
		}
		if (dUV < min) {
			min = dUV;
		}
		return min;
	}

}
