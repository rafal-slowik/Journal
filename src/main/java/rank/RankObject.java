/**
 * 
 */
package rank;

/**
 * @author Rafal Slowik
 * @date 9 Mar 2017
 *
 */
public abstract class RankObject<E> {

	protected final int rankPosition;
	protected final E rankedObject;

	/**
	 * 
	 */
	public RankObject(int rankPosition, E rankedObject) {
		this.rankedObject = rankedObject;
		this.rankPosition = rankPosition;
	}

	/**
	 * @return the rankedObject
	 */
	public E getRankedObject() {
		return rankedObject;
	}
	
	/**
	 * @return the rankPosition
	 */
	public int getRankPosition() {
		return rankPosition;
	}

	public abstract String printValues();
}
