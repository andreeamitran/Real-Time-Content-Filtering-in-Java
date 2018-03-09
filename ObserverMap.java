//package observersPackage;
import java.util.TreeMap;

/**
 * Clasa ObserverMap
 * @author andreeam
 *
 */
public class ObserverMap implements Observers {
	
	//instanta Singleton TreeMap de Observatori
	private static TreeMap<Integer, Observer> obsMap = 
			new TreeMap<Integer, Observer>();
	
	/**
	 * Constructor
	 */
	public ObserverMap () {}
	
	/**
	 * Returneaza TreeMap de Observatori
	 * @return TreeMap<Integer, Observer>
	 */
	public static TreeMap<Integer, Observer> getMap () {
		return obsMap;
	}
}
