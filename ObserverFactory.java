//package observersPackage;

/**
 * Clasa ObserverFactory
 * @author andreeam
 *
 */
public class ObserverFactory {
	
	//instanta Singleton de Observer Factory
	private static ObserverFactory instance = new ObserverFactory();
	
	/**
	 * Constructor
	 */
	private ObserverFactory () {}
	
	/**
	 * Returneaza instanta Singleton de Observer Factory
	 * @return ObserverFactory
	 */
	public ObserverFactory getInstance () {
		return instance;
	}
	
	/**
	 * Returneaza o noua mapa de Observatori
	 * @return
	 */
	public static Observer getObserver () {
		return new Observer();
	}
	
}
