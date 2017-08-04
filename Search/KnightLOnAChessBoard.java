
public class KnightLOnAChessBoard {

	// Thoughts: we can use an algorithm similar to prims
	// Basically: 
	//	    Use a graph G consisting of all possible positions
	//		perform a BFS from starting position (0,0) to all
	//		reachable vertices, marking unvisited nodes as visited
	//      and the amount of turns it took to find
	//		
	//		This pre-computation takes up to O(N^2) visits (a,b) = (1,1)
	//		however, ALL destinations lookups are O(1) after pre-computation
	//      is finished
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Create NxN positions graph "visited" to track if a position has been visited
//		Create NxN graph "distTo" to track amount of moves to each position, and
//		initialize all positions to -1
//		track amount of moves via "moves"
//		Create array "positions" to track newly visited nodes
//		Add our starting position (0,0) to "positions"
//		while "positions" isn't empty:
//			create array "discovered" to hold all newly reachable nodes 
//			For each p in "positions"
//				if p isn't visited
//					mark p visited
//					record "distTo" of p
//					add unvisited unreachable nodes from p to "discovered"
//			replace "positions" with "discovered"
//		Print each position in distTo
//		
//		

	}

}
