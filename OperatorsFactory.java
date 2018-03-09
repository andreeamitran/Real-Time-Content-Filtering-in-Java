//package operatorsPackage;

/**
 * Factory pentru Operatori
 * @author andreeam
 *
 */
public class OperatorsFactory {

	//instanta unica
	private static OperatorsFactory instance = new OperatorsFactory();
	
	/**
	 * constructor
	 */
	private OperatorsFactory () {}
	
	/**
	 * Returneaza instanta unica
	 * @return
	 */
	public static OperatorsFactory getInstance () {
		return instance;
	}
	
	/**
	 * Returneaza un obiect de tip Operator
	 * @param operatorType
	 * @return Operator
	 */
	public Operator getOperator (String operatorType) {
		if (operatorType == null)
			return null;
		if (operatorType.equalsIgnoreCase("eq"))
			return new Equal();
		if (operatorType.equalsIgnoreCase("ne"))
			return new NotEqual();
		if (operatorType.equalsIgnoreCase("gt"))
			return new Greater();
		if (operatorType.equalsIgnoreCase("ge"))
			return new GreaterEqual();
		if (operatorType.equalsIgnoreCase("lt"))
			return new Less();
		if (operatorType.equalsIgnoreCase("le"))
			return new LessEqual();
		
		return null;
	}
	
}
