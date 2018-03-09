//package operatorsPackage;

/**
 * Clasa SingletonOperator
 * @author andreeam
 *
 */
public class SingletonOperator {
	
	//instanta Singleton
	private static SingletonOperator s = new SingletonOperator();
	
	/**
	 * Constructor SingletonOperator
	 */
	private SingletonOperator () {}
	
	/**
	 * Returneaza instanta Singleton
	 * @return
	 */
	public static SingletonOperator getInstance () {
		return s;
	}
	
	/**
	 * Genereaza un nou operator in functie de parametrul primit
	 * @param operatorType
	 * @return
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
