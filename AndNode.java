//package expressionPackage;

/**
 * Clasa AndNode
 * @author andreeam
 *
 */
public class AndNode extends Node implements Visitable {
	
	/**
	 * Constructor nod cu operator &&
	 * @param left
	 * @param right
	 */
	public AndNode (Node left, Node right) {
		super (left, right);
	}
	
	/**
	 * Functia accept
	 * @param visitor
	 * @return Visitor
	 */
	public boolean accept(Visitor visitor) {
		return visitor.visit(this);
	}
	
}
