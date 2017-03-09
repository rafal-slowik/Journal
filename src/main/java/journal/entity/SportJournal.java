/**
 * 
 */
package journal.entity;

import annotation.Rankable;
import journal.Journal;

/**
 * @author Rafal Slowik
 * @date 8 Mar 2017
 *
 */
@Rankable
public class SportJournal extends Journal {

	/**
	 * @param journalName
	 * @param score
	 */
	public SportJournal(String journalName, float score) {
		super(journalName, score);
	}
}
