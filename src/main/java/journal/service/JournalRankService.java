package journal.service;

import static config.ConfigProperties.getInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import journal.Journal;
import rank.JournalRankObject;
import rank.Rank;

/**
 * 
 * @author Rafal Slowik
 * @date 8 Mar 2017
 *
 */
public class JournalRankService implements Rank<Journal> {

	/**
	 * 
	 * 
	 * @param journals
	 *            - set of journals to be filtered, compared and ranked. The set
	 *            must not be null
	 * @throws IllegalArgumentException
	 *             if the set of journals is null
	 * @return ranked journals
	 */
	public List<JournalRankObject> journalsRank(Set<Journal> journals) {

		if (journals == null) {
			throw new IllegalArgumentException(
					getInstance().formatProperty("value_cannot_be_null", "The journals set"));
		}

		List<Journal> sortedJournals = sortRankable(journals);
		List<JournalRankObject> result = new ArrayList<>(sortedJournals.size());

		int rankCounter = 1;
		int rankPositionToInsert = 1;
		Journal lastJournal = null;
		for (Journal currentJournal : sortedJournals) {
			if (lastJournal != null && currentJournal.getScore() != lastJournal.getScore()) {
				rankPositionToInsert = rankCounter;
			}
			lastJournal = currentJournal;
			JournalRankObject rankObject = new JournalRankObject(rankPositionToInsert, currentJournal);
			result.add(rankObject);
			rankCounter++;
		}
		return result;
	}
}
