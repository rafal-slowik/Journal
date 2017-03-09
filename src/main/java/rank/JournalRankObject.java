/**
 * 
 */
package rank;

import journal.Journal;

/**
 * @author Rafal Slowik
 * @date 9 Mar 2017
 *
 */
public class JournalRankObject {

	private final int rankPosition;
	private final Journal rankedObject;

	/**
	 * 
	 */
	public JournalRankObject(int rankPosition, Journal rankedObject) {
		this.rankedObject = rankedObject;
		this.rankPosition = rankPosition;
	}

	/**
	 * @return the rankedObject
	 */
	public Journal getRankedObject() {
		return rankedObject;
	}

	/**
	 * @return the rankPosition
	 */
	public int getRankPosition() {
		return rankPosition;
	}

	public String printValues() {
		StringBuilder sb = new StringBuilder();
		return sb.append(getRankPosition()).append("     ").append(getRankedObject().getJournalName()).append("     ")
				.append(getRankedObject().getScore()).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rankPosition;
		result = prime * result + ((rankedObject == null) ? 0 : rankedObject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JournalRankObject other = (JournalRankObject) obj;
		if (rankPosition != other.rankPosition)
			return false;
		if (rankedObject == null) {
			if (other.rankedObject != null)
				return false;
		} else if (!rankedObject.equals(other.rankedObject))
			return false;
		return true;
	}
}
