//package mainPackage;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

//import observersPackage.Observer;
//import observersPackage.ObserverFactory;
//import observersPackage.ObserverMap;

/**
 * Main Class
 * @author andreeam
 *
 */
public class MainClass {
	
	/**
	 * Functia main
	 * @param args
	 */
	public static void main (String args[]) {
		String line;
		String[] split;
		int value;
		TreeMap<Integer, Observer> obsMap = ObserverMap.getMap();
		ArrayList<Feed> feed = new ArrayList<Feed>();
		Observer obs = new Observer();
		Feed f = new Feed();
		
		Scanner s = new Scanner(System.in);
		while(true) {
			//citeste si parseaza (elimina spatiile in plus)
			line = s.nextLine();
			line = line.trim().replaceAll(" +", " ");
			if (line.equals("end"))
				break;
			split = line.split(" ");
			String strForObs = "\0";
			
			//pentru comanda "create_obs"
			if (split[0].equals("create_obs")) {
				//parseaza expresia dupa spatiu (elimina spatiile)
				//si adauga spatii inainte si dupa paranteze
				value = Integer.parseInt(split[1]);
				for(int i = 2; i < split.length; i++) {
					strForObs = strForObs + split[i];
					strForObs = strForObs + " ";
				}
				strForObs = strForObs.trim().replaceAll("\\(", "( ");
				strForObs = strForObs.trim().replaceAll("\\)", " )");
				strForObs = strForObs.trim().replaceAll(" +", " ");
				
				//adauga un nou observator cu obs_id
				obsMap.put(value, ObserverFactory.getObserver());
				//salveaza expresia lui
				obsMap.get(value).setExpression(strForObs);
				//ataseaza un nou observator
				obs.attach(obsMap, feed, strForObs, value);
			}
			
			//pentru comanda "feed"
			else if (split[0].equals("feed")) {
				//update feed
				f.updateFeed(feed, split[1], split[2]);
				//notifica observatorii cu schimbarea de feed
				obs.notifyAllObservers(obsMap, split[1],
						Double.parseDouble(split[2]));
			}
			
			//pentru comanda "delete_obs"
			else if (split[0].equals("delete_obs")) {
				//sterge din Treemap observatorul
				obsMap.remove(Integer.parseInt(split[1]));
			}
			
			//pentru comanda "print"
			else if (split[0].equals("print")) {
				int value1 = Integer.parseInt(split[1]);
				//cauta valoarea in TreeMap
				for(String key : obsMap.get(value1).getObsFeed().keySet()) {
					if (obsMap.get(value1).getState(key) == true) {
						//afiseaza obs_id
						System.out.print("obs " + split[1] + ": ");
						System.out.print(obsMap.get(value1).getObsFeed().get(key).getName() + " ");
						//update pentru procent
						if (obsMap.get(value1).getObsFeed().get(key).getNrOfChanges() == 0) {
							obsMap.get(value1).updateFeedProc
								(key, obsMap.get(value1).getLastPrintValue(key));
						}
						//afiseaza cu precizie de 2 zecimale
						System.out.print(String.format(Locale.ROOT, "%.2f", 
							obsMap.get(value1).getFeedValue(key)) + " ");
						System.out.print(String.format(Locale.ROOT, "%.2f", 
							obsMap.get(value1).getObsFeed().get(key).getproc()) + "% ");
						//afiseaza numarul de schimbari
						System.out.print(obsMap.get(value1).getNrOfChanges(key));
						System.out.println("");
						//update pentru ultima valoare afisata
						obsMap.get(value1).updateLastPrintValue
							(key, obsMap.get(value1).getFeedValue(key));
						//reseteaza numarul de schimbari
						obsMap.get(value1).updateFeedNrOfChanges(key, 0);
					}
				}
			}
		}
		
		s.close();
	}
}
