//package operatorsPackage;

/**
 * Clasa Equal
 * @author andreeam
 *
 */
public class Equal implements Operator {
	
	/**
	 * Verifica daca doua numere sunt egale
	 */
	public boolean compareNumbers (double nr1, double nr2) {
		if (nr1 == nr2)
			return true;
		return false;
	}
	
	/**
	 * Verifica daca doua siruri sunt egale
	 */
	public boolean compareStrings (String str1, String str2) {
		if (str1.equals(str2))
			return true;
		return false;
	}
}
