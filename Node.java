//package expressionPackage;

/**
 * Clasa Node
 * @author andreeam
 *
 */
public class Node implements Visitable {

	//fiul stang
	private Node Left;
	//fiul drept
	private Node Right;
	
	/**
	 * Returneaza fiul stang
	 * @return Node
	 */
	public Node getLeftNode () {
		return Left;
	}
	
	/**
	 * Returneaza fiul drept
	 * @return Node
	 */
	public Node getRightNode () {
		return Right;
	}
	
	/**
	 * Constructor
	 * @param Left
	 * @param Right
	 */
	public Node (Node Left, Node Right) {
		this.Left = Left;
		this.Right = Right;
	}
	
	/**
	 * Functia accept
	 */
	public boolean accept(Visitor visitor) {
		return false;
	}

}
