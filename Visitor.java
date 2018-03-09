//package expressionPackage;

/**
 * Interfata Visitor
 * @author andreeam
 *
 */
public interface Visitor {
	
	/**
	 * Viziteaza nod de tip AndNode (operator &&)
	 * @param operatorNode
	 * @return AndNode
	 */
	boolean visit (AndNode operatorNode);
	
	/**
	 * Viziteaza nod de tip OrNode (operator ||)
	 * @param operatorNode
	 * @return OrNode
	 */
	boolean visit (OrNode operatorNode);
	
	/**
	 * 
	 * @param operantNode
	 * @return OperandNode
	 */
	boolean visit (OperandNode operantNode);
}
