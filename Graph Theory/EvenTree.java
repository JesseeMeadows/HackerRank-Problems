import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Problem: "Even Tree"
  * 	url: https://www.hackerrank.com/challenges/even-tree/problem
  * 	
  * 	Thoughts: You can remove edges between 2 trees when atleast one of the 2 trees
  * 	contain an even amount of vertices. So a quick solution would be a bfs that counts
  * 	the amount of even weighted subtrees
  */
public class EvenTree {
	public int weight;
	public ArrayList<Integer> list;
	
	public EvenTree() {
		this.weight = 1;
		this.list = new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		ArrayList<EvenTree> g = new ArrayList<EvenTree>(n + 1);
		for (int i = 0; i <= n; i++) {
			g.add(new EvenTree());
		}
		for (int i = 0; i < m; i++) {
			in.nextLine();
			int u = in.nextInt();
			int v = in.nextInt();
			g.get(u).list.add(v);
			g.get(v).list.add(u);
		}
		Integer removedCount = dfs(g, 1, -1);
		System.out.println(removedCount);
		
	}
	
	public static int dfs(List<EvenTree> g, int v, int prev) {
		int count = 0;
		for (Integer x: g.get(v).list) {
			if (x != prev) {
				
				count += dfs(g, x, v);
				int stWeight = g.get(x).weight;
				if (stWeight > 1 && stWeight % 2 == 0) {
					count++;
				} else {
					g.get(v).weight += stWeight;
				}
			}
		}
		return count;
	}
}
