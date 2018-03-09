//package operatorsPackage;

/**
 * Clasa GreaterEqual
 * @author andreeam
 *
 */
public class GreaterEqual implements Operator {
	
	/**
	 * Verifica daca nr1 >= nr2
	 */
	public boolean compareNumbers (double nr1, double nr2) {
		if (nr1 >= nr2)
			return true;
		return false;
	}
	
	/**
	 * Returneaza true pentru siruri (no use)
	 */
	public boolean compareStrings (String str1, String str2) {
		return true;
	}

}
