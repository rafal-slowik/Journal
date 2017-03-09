package journal.entity;

import journal.Journal;

/**
 * 
 * @author Rafal Slowik
 * @date 8 Mar 2017
 *
 */
public class ReviewJournal extends Journal {

	/**
	 * @param journalName
	 * @param score
	 */
	public ReviewJournal(String journalName, float score) {
		super(journalName, score);
	}
}
