//package operatorsPackage;

/**
 * Clasa NotEqual
 * @author andreeam
 *
 */
public class NotEqual implements Operator {
	
	/**
	 * Verifica daca nr1 != nr2
	 */
	public boolean compareNumbers (double nr1, double nr2) {
		if (nr1 != nr2)
			return true;
		return false;
	}
	
	/**
	 * Verifica daca sirurile nu sunt egale
	 */
	public boolean compareStrings (String str1, String str2) {
		if (str1.equals(str2))
			return false;
		return true;
	}
}
