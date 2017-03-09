package journal;

import static config.ConfigProperties.getInstance;

import java.util.Comparator;

/**
 * 
 * @author Rafal Slowik
 * @date 9 Mar 2017
 *
 */
public abstract class Journal implements Comparable<Journal> {
	private final String journalName;
	private final float score;

	public Journal(String journalName, float score) {
		if (journalName == null) {
			throw new IllegalArgumentException(
					getInstance().formatProperty("value_cannot_be_null", "The name of the journal"));
		}

		this.journalName = journalName;
		this.score = score;
	}

	public String getJournalName() {
		return journalName;
	}

	public float getScore() {
		return score;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "{journalName=" + this.journalName + ", score=" + this.score + "}";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Journal o) {
		return Comparator.comparing(Journal::getScore).reversed().thenComparing(Journal::getJournalName).compare(this,
				o);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((journalName == null) ? 0 : journalName.hashCode());
		result = prime * result + Float.floatToIntBits(score);
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
		Journal other = (Journal) obj;
		if (journalName == null) {
			if (other.journalName != null)
				return false;
		} else if (!journalName.equals(other.journalName))
			return false;
		if (Float.floatToIntBits(score) != Float.floatToIntBits(other.score))
			return false;
		return true;
	}
}
