//package expressionPackage;

/**
 * Interfata Visitable
 * @author andreeam
 *
 */
public interface Visitable {
	/**
	 * Functia accept
	 * @param visitor
	 * @return Visitor
	 */
	boolean accept (Visitor visitor);
}
