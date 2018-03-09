//package mainPackage;

import java.util.ArrayList;

/**
 * 
 * @author andreeam
 *
 */
public class Feed {
	private String name;
	private double value;
	private double proc;
	private int nrOfChanges;
	private double lastPrintValue;
	private boolean state;
	
	/**
	 * constructor Feed fara parametri
	 */
	public Feed () {}
	
	/**
	 * constructor Feed cu parametri
	 * @param name
	 * @param value
	 */
	public Feed (String name, double value) {
		this.name = name;
		this.value = value;
		proc = 0.00;
		nrOfChanges = 0;
		lastPrintValue = 0;
		state = true;
	}
	
	/**
	 * Returneaza starea de afisare
	 * @return boolean
	 */
	public boolean getState () {
		return state;
	}
	
	/**
	 * Returneaza numele Feed-ului
	 * @return String
	 */
	public String getName () {
		return name;
	}
	
	/**
	 * Returneaza valoarea Feed-ului
	 * @return double
	 */
	public double getValue () {
		return value;
	}
	
	/**
	 * Returneaza fluctuatia
	 * @return double
	 */
	public double getproc () {
		return proc;
	}
	
	/**
	 * Returneaza numarul de schimbai de la ultima afisare
	 * @return int
	 */
	public int getNrOfChanges () {
		return nrOfChanges;
	}
	
	/**
	 * Returneaza ultima valoare afisata
	 * @return double;
	 */
	public double getlastPrintValue () {
		return lastPrintValue;
	}
	
	/**
	 * Seteaza numele feed-ului
	 * @param name
	 */
	public void setName (String name) {
		this.name = name;
	}
	
	/**
	 * Seteaza valoarea feed-ului
	 * @param value
	 */
	public void setValue (double value) {
		this.value = value;
	}
	
	/**
	 * Seteaza/Modifica procentul
	 * @param newValue
	 */
	public void setProc (double newValue) {
		if (lastPrintValue != 0)
			proc = (newValue - lastPrintValue) * 100 / lastPrintValue;
	}
	
	/**
	 * Seteaza/Modifica ultima valoare printata
	 * @param value
	 */
	public void setlastPrintValue (double value) {
		lastPrintValue = value;
	}
	
	/**
	 * Seteaza/Modifica numarul de schimbari de feed
	 * @param value
	 */
	public void setNrOfChanges (int value) {
		nrOfChanges = value;
	}
	
	/**
	 * Seteaza/Modifica starea (True - afiseaza,
	 * False - nu afiseaza la comanda print)
	 * @param value
	 */
	public void setState (boolean value) {
		state = value;
	}
	
	/**
	 * Modifica/Adauga valoarea unui feed
	 * @param feed
	 * @param str
	 * @param value
	 */
	public void updateFeed (ArrayList<Feed> feed, String str, String value) {
		int ok = 0;
		for(int i = 0; i < feed.size(); i++) {
			if ((feed.get(i).getName()).equals(str)) {
				feed.get(i).setValue(Double.parseDouble(value));
				ok = 1;
				break;
			}
		}
		if (ok == 0) {
			feed.add(new Feed(str, Double.parseDouble(value)));
		}
	}
}
