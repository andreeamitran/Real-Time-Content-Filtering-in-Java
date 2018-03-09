//package operatorsPackage;

/**
 * Interfata Operator
 * @author andreeam
 *
 */
public interface Operator {
	/**
	 * Functia de comparare a doua numere
	 * @param nr1
	 * @param nr2
	 * @return boolean
	 */
	boolean compareNumbers (double nr1, double nr2);
	/**
	 * Functia de comparare a doua string-uri
	 * @param str1
	 * @param str2
	 * @return boolean
	 */
	boolean compareStrings (String str1, String str2);
}
