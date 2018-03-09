//package expressionPackage;

/**
 * Clasa OperandNode
 * @author andreeam
 *
 */
public class OperandNode extends Node implements Visitable {

	//valoarea operandului (True/False)
	private boolean Value;
	
	/**
	 * Returneaza valoarea operandului
	 * @return boolean
	 */
	public boolean getValue () {
		return Value;
	}
	
	/**
	 * Constructor nod operand
	 * @param Value
	 */
	public OperandNode (boolean Value) {
		super(null, null);
		this.Value = Value;
	}
	
	/**
	 * Functia accept (viziteaza)
	 * @return Visitor
	 */
	public boolean accept(Visitor visitor) {
		return visitor.visit(this);
	}

}
