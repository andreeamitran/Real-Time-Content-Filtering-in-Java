//package expressionPackage;

/**
 * Clasa OrNode
 * @author andreeam
 *
 */
public class OrNode extends Node implements Visitable {

	/**
	 * Constructor nod Or
	 * @param Left
	 * @param Right
	 */
	public OrNode (Node Left, Node Right) {
		super (Left, Right);
	}
	
	/**
	 * Functia accept (viziteaza)
	 * @return Visitor
	 */
	public boolean accept(Visitor visitor) {
		return visitor.visit(this);
	}

}
