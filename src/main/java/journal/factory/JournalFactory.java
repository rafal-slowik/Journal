/**
 * 
 */
package journal.factory;

import config.ConfigProperties;
import journal.Journal;
import journal.entity.DeveloperJournal;
import journal.entity.ReviewJournal;
import journal.entity.SportJournal;

/**
 * Journal factory class which is also singleton.
 * 
 * @author Rafal Slowik
 * @date 9 Mar 2017
 *
 */
public class JournalFactory {

	private JournalFactory() {
	}

	public static JournalFactory getInstance() {
		return SingletonHelper.INSTANCE;
	}

	private static class SingletonHelper {
		private static JournalFactory INSTANCE = new JournalFactory();
	}

	public Journal create(JournalType type, final String journalName, final float score) {
		if (type == null) {
			throw new IllegalArgumentException(
					ConfigProperties.getInstance().formatProperty("value_cannot_be_null", "The journal type"));
		}
		switch (type) {
		case DEVELOPER:
			return new DeveloperJournal(journalName, score);
		case REVIEW:
			return new ReviewJournal(journalName, score);
		case SPORT:
			return new SportJournal(journalName, score);
		default:
			throw new IllegalArgumentException(
					"The following argument is illegal: \"" + type == null ? "null" : type.toString() + "\"");
		}
	}

	/**
	 * @author Rafal Slowik
	 * @date 9 Mar 2017
	 *
	 */
	public enum JournalType {
		DEVELOPER, REVIEW, SPORT;
	}
}
