package rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import annotation.Rankable;

/**
 * 
 * @author Rafal Slowik
 * @date 8 Mar 2017
 *
 */
public interface Rank<E> {

	public default List<E> sortRankable(Set<E> itemsToRank) {
		if (itemsToRank == null) {
			return new ArrayList<>();
		}

		return itemsToRank.stream().filter(p -> p.getClass().isAnnotationPresent(Rankable.class))
				.sorted().collect(Collectors.toCollection(ArrayList::new));
	}
}
