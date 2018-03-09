//package expressionPackage;

import java.util.ArrayList;

//import operatorsPackage.Operator;

//import operatorsPackage.OperatorsFactory;

/**
 * Clasa ExprTrans
 * @author andreeam
 *
 */
public class ExprTrans {
	
	/**
	 * Returneaza coada ce contine expresia in postfix
	 * @param str
	 * @param name
	 * @param value
	 * @return QueueExpression
	 */
	public QueueExpression shuntingYard (String str, String name, double value) {
		//imparte expresia in subsiruri dupa caracterul spatiu
		String split[] = str.split(" ");
		OperatorsFactory factory = OperatorsFactory.getInstance();
		Operator obs;
		String[] queue = new String[100];
		String[] stack = new String[100];
		boolean result;
		int countq = 0;
		int counts = 0;
		
		//cat timp mai exista subsiruri in sir
		for(int i = 0; i < split.length; i++) {
			//daca este paranteza "(" o adauga in stiva
			if (split[i].equals("(")) {
				stack[counts] = split[i];
				counts++;
			}
			//daca este operator de comparare, returneaza rezultatul compararii
			else if (split[i].equals("le") || split[i].equals("lt") ||
					split[i].equals("ge") || split[i].equals("gt") ||
					split[i].equals("eq") || split[i].equals("ne")) {
				obs = factory.getOperator(split[i]);
				if (split[i+1].equals("name"))
					result = obs.compareStrings(name, split[i+2]);
				else
					result = obs.compareNumbers(value, 
							Double.parseDouble(split[i+2]));
				//adauga rezultatul in coada finala
				queue[countq] = Boolean.toString(result);
				countq++;
			}
			//daca este operator "||" sau "&&"
			else if (split[i].equals("||") || split[i].equals("&&")) {
				if (counts > 0) {
					//cat timp este "||" sau "&&"
					while (stack[counts-1].equals("||") ||
							stack[counts-1].equals("&&")) {
						//scoate din stiva si adauga in coada
						queue[countq] = stack[counts-1];
						countq++;
						counts--;
					}
				}
				//adauga operator in stiva
				stack[counts] = split[i];
				counts++;
			}
			//daca este paranteza ")" scoate din stiva si adauga
			//in coada pana se ajunge la "(" (inclusiv)
			else if (split[i].equals(")")) {
				while (!(stack[counts-1].equals("("))) {
					queue[countq] = stack[counts-1];
					countq++;
					counts--;
				}
				counts--;
			}
		}
		//daca au mai ramas elemente in stiva si nu sunt
		//paranteze, le scoate si le adauga la coada finala
		while (counts > 0) {
			if (stack[counts-1] != "(" && stack[counts-1] != ")") {
				queue[countq] = stack[counts-1];
				countq++;
				counts--;
			}
		}
		//returneaza coada expresiei si numarul de elemente
		QueueExpression exp = new QueueExpression(queue, countq);
		return exp;
	}
	
	/**
	 * Clasa tree - crearea arborelui
	 * @param queue
	 * @param count
	 * @return Node
	 */
	public Node tree (String[] queue, int count) {
		
		AndNode andNode;
		OrNode orNode;
		//coada
		ArrayList<Node> ar = new ArrayList<Node>();
		//cat timp mai sunt elemente in coada
		for(int i = 0; i < count; i++) {
			//daca este operand True/False
			if (queue[i].equals("true") || queue[i].equals("false")) {
				//adauga in coada un nou nod
				ar.add(new OperandNode(Boolean.parseBoolean(queue[i])));
			}
			//daca este operator "||"
			else if (queue[i].equals("||")) {
				//creeaza nod in arbore cu fii ultimii 2 predecesori
				orNode = new OrNode(ar.get(ar.size()-2), ar.get(ar.size()-1));
				//scoate din coada predecesorii
				ar.remove(ar.size()-2);
				ar.remove(ar.size()-1);
				//adauga noul nod in coada
				ar.add(orNode);
			}
			//daca este operator "&&"
			else if (queue[i].equals("&&")) {
				//creeaza nod in arbore cu fii ultimii 2 predecesori
				andNode = new AndNode(ar.get(ar.size()-2), ar.get(ar.size()-1));
				//scoade din coada predecesorii
				ar.remove(ar.size()-2);
				ar.remove(ar.size()-1);
				//adauga nou nod in coada
				ar.add(andNode);
			}
		}
		//radacina arborelui (ultimul nod din coada)
		return ar.get(ar.size()-1);
	}
}
