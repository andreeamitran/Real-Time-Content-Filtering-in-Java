//package expressionPackage;

/**
 * Clasa QueueExpression
 * @author andreeam
 *
 */
public class QueueExpression {
	
	//coada expresiei in postfix
	private String queue[];
	//numarul de elemente din coada
	private int count;
	
	/**
	 * Constructor QueueExpression
	 * @param queue
	 * @param count
	 */
	public QueueExpression (String[] queue, int count) {
		this.queue = queue;
		this.count = count;
	}
	
	/**
	 * Returneaza coada
	 * @return String[]
	 */
	public String[] getQueue () {
		return queue;
	}
	
	/**
	 * Returneaza numarul de elemente din coada
	 * @return int
	 */
	public int getCount () {
		return count;
	}
	
}
