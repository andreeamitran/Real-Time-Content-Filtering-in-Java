//package expressionPackage;

/**
 * Clasa CalculatorVisitor
 * @author andreeam
 *
 */
public class CalculatorVisitor implements Visitor {
	
	/**
	 * Viziteaza un nod de tipul AndNode (operator &&)
	 * @param operatorNode
	 */
	public boolean visit (AndNode operatorNode) {
		return operatorNode.getLeftNode().accept(this) &&
				operatorNode.getRightNode().accept(this);
	}
	
	/**
	 * Viziteaza un nod de tipul OrNode (operator ||)
	 * @param operatorNode
	 */
	public boolean visit (OrNode operatorNode) {
		return operatorNode.getLeftNode().accept(this) ||
				operatorNode.getRightNode().accept(this);
	}
	
	/**
	 * Viziteaza un nod de tipul OperandNode (operand True/False)
	 * @param operandNode
	 */
	public boolean visit (OperandNode operandNode) {
		return operandNode.getValue();
	}
}
