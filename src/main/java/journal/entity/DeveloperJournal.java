/**
 * 
 */
package journal.entity;

import annotation.Rankable;
import journal.Journal;

/**
 * @author Rafal Slowik
 * @date 9 Mar 2017
 *
 */
@Rankable
public final class DeveloperJournal extends Journal {

	/**
	 * @param journalName
	 * @param score
	 */
	public DeveloperJournal(String journalName, float score) {
		super(journalName, score);
	}
}
