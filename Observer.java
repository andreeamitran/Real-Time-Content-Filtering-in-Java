//package observersPackage;

import java.util.ArrayList;
import java.util.TreeMap;

//import expressionPackage.CalculatorVisitor;
//import expressionPackage.ExprTrans;
//import expressionPackage.Node;
//import expressionPackage.QueueExpression;

//import mainPackage.Feed;

/**
 * Clasa Observer
 * @author andreeam
 *
 */
public class Observer {
	private TreeMap<String, Feed> obsFeed;
	private String expression;
	
	/**
	 * Constructor Observer fara parametri
	 */
	public Observer () {
		obsFeed = new TreeMap<String, Feed>();
		expression = "\0";
	}
	
	/**
	 * Returneaza feed-urile unui Observator
	 * @return TreeMap<String, Feed>
	 */
	public TreeMap<String, Feed> getObsFeed () {
		return obsFeed;
	}
	
	/**
	 * Returneaza valoarea expresiei filtru
	 * @return String
	 */
	public String getExpression () {
		return expression;
	}
	
	/**
	 * Seteaza valoarea expresiei filtru
	 * @param expression
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	/**
	 * Seteaza/Modifica valoarea unui feed
	 * @param name
	 * @param value
	 */
	public void updateFeedValue (String name, double value) {
		obsFeed.get(name).setValue(value);
	}
	
	/**
	 * Seteaza/Modifica valoarea fluctuatiei
	 * @param name
	 * @param value
	 */
	public void updateFeedProc (String name, double value) {
		obsFeed.get(name).setProc(value);
	}
	
	/**
	 * Seteaza/Modifica numarul de schimbari de feed
	 * @param name
	 * @param value
	 */
	public void updateFeedNrOfChanges (String name, int value) {
		obsFeed.get(name).setNrOfChanges(value);
	}
	
	/**
	 * Adauga un nou feed
	 * @param name
	 * @param value
	 */
	public void setFeed (String name, double value) {
		obsFeed.put(name, new Feed(name, value));
	}
	
	/**
	 * Returneaza numarul de schimbari de feed
	 * @param name
	 * @return int
	 */
	public int getNrOfChanges (String name) {
		return obsFeed.get(name).getNrOfChanges();
	}
	
	/**
	 * Seteaza/Modifica ultima valoare printata
	 * @param name
	 * @param value
	 */
	public void updateLastPrintValue (String name, double value) {
		obsFeed.get(name).setlastPrintValue(value);
	}
	
	/**
	 * Returneaza valoarea unui feed
	 * @param name
	 * @return double
	 */
	public double getFeedValue (String name) {
		return obsFeed.get(name).getValue();
	}

	/**
	 * Seteaza/Modifica starea unui de afisare a unui feed
	 * @param name
	 * @param value
	 */
	public void setState (String name, boolean value) {
		obsFeed.get(name).setState(value);
	}
	
	/**
	 * Returneaza starea de afisare a unui feed
	 * @param name
	 * @return boolean
	 */
	public boolean getState (String name) {
		return obsFeed.get(name).getState();
	}
	
	/**
	 * Returneaza ultima valoare printata
	 * @param name
	 * @return double
	 */
	public double getLastPrintValue (String name) {
		return obsFeed.get(name).getlastPrintValue();
	}
	
	/**
	 * Ataseaza un nou observator in TreeMap
	 * @param obsMap
	 * @param feed
	 * @param str
	 * @param value
	 */
	public void attach (TreeMap<Integer, Observer> obsMap,
			ArrayList<Feed> feed, String str, int value) {
		//fara expresie filtru
		if (str.equals("nil")) {
			//ia toate feed-urile
			for(int i = 0; i < feed.size(); i++) {
				obsMap.get(value).setFeed(feed.get(i).getName(), 
						feed.get(i).getValue());
			}
		}
		else {
			for(int i = 0; i < feed.size(); i++) {
				//seteaza feed
				obsMap.get(value).setFeed(feed.get(i).getName(), 
						feed.get(i).getValue());
				//rezolvarea expresiei
				ExprTrans exprTrans = new ExprTrans();
				QueueExpression exp = exprTrans.shuntingYard(str,
						feed.get(i).getName(), feed.get(i).getValue());
				Node node = exprTrans.tree(exp.getQueue(), exp.getCount());
				boolean result = node.accept(new CalculatorVisitor());
				//daca nu a trecut filtrul
				if (result == false) {
					//seteaza starea false
					obsMap.get(value).setState(feed.get(i).getName(), false);
				}
				//daca a trecut filtrul
				else
					//seteaza starea true
					obsMap.get(value).setState(feed.get(i).getName(), true);
			}
		}
	}
	
	/**
	 * Notifica observatorii la adaugarea unui nou feed
	 * @param obsMap
	 * @param str
	 * @param value
	 */
	public void notifyAllObservers (TreeMap<Integer, Observer> obsMap,
			String str, Double value) {
		//pentru fiecare observator
		for(Integer key : obsMap.keySet()) {
			//fara filtru
			if (obsMap.get(key).getExpression().equals("nil")) {
				//daca exista cheia, face update la valoare si procent
				if (obsMap.get(key).getObsFeed().containsKey(str)) {
					obsMap.get(key).updateFeedValue(str,value);
					obsMap.get(key).updateFeedProc(str,value);
				}
				//altfel, creeaza feed-ul
				else
					obsMap.get(key).setFeed(str, value);
			}
			else {
				//rezolvarea expresiei filtru
				QueueExpression exp;
				ExprTrans exprTrans = new ExprTrans();
				exp = exprTrans.shuntingYard(obsMap.get(key).getExpression(),
							str, value);
				Node node = exprTrans.tree(exp.getQueue(), exp.getCount());
				boolean result = node.accept(new CalculatorVisitor());
				//daca trece de filtru
				if (result == true) {
					//daca exista cheia
					if (obsMap.get(key).getObsFeed().containsKey(str)) {
						//face update
						obsMap.get(key).updateFeedValue(str, value);
					}
					else {
						//altfel, seteaza un nou feed
						obsMap.get(key).setFeed(str, value);
					}
					//stare de afisare true
					obsMap.get(key).setState(str, true);
					//update la procent
					if (obsMap.get(key).getLastPrintValue(str) != 0) {
						obsMap.get(key).updateFeedProc(str, value);
					}
				}
				else {
					//construiste feed nou daca nu exista
					if (!obsMap.get(key).getObsFeed().containsKey(str))
						obsMap.get(key).setFeed(str, value);
					//starea de afisare este false
					obsMap.get(key).setState(str, false);
				}
			}
			//modifica numarul de schimbari ale unui feed
			obsMap.get(key).updateFeedNrOfChanges(str,
					obsMap.get(key).getNrOfChanges(str) + 1);
		}
	}
}
