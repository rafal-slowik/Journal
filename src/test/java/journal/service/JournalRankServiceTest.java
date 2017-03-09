/**
 * 
 */
package journal.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import journal.Journal;
import journal.factory.JournalFactory;
import journal.factory.JournalFactory.JournalType;
import rank.JournalRankObject;

/**
 * @author Rafal Slowik
 * @date 9 Mar 2017
 *
 */
public class JournalRankServiceTest {

	private JournalRankService service;
	private Set<Journal> inputScenerio1 = new HashSet<>(3);
	private List<JournalRankObject> shouldResultScenerio1 = new ArrayList<>(3);

	private Set<Journal> inputScenerio2 = new HashSet<>(3);;
	private List<JournalRankObject> shouldResultScenerio2 = new ArrayList<>(3);

	private Set<Journal> inputScenerio3 = new HashSet<>(3);;
	private List<JournalRankObject> shouldResultScenerio3 = new ArrayList<>(3);

	private Set<Journal> inputScenerio4 = new HashSet<>(3);;
	private List<JournalRankObject> shouldResultScenerio4 = new ArrayList<>(3);

	@Before
	public void init() {
		service = new JournalRankService();
		generateScenario1();
		generateScenario2();
		generateScenario3();
		generateScenario4();
	}

	@Test
	public void uniqueObjectsScenerio1() {
		List<JournalRankObject> result = service.journalsRank(inputScenerio1);
		compareResultList(shouldResultScenerio1, result);
	}

	@Test
	public void sharedRankScenerio2() {
		List<JournalRankObject> result = service.journalsRank(inputScenerio2);
		compareResultList(shouldResultScenerio2, result);
	}

	@Test
	public void excludingReviewJournalsScenerio3() {
		List<JournalRankObject> result = service.journalsRank(inputScenerio3);
		compareResultList(shouldResultScenerio3, result);
	}

	@Test
	public void onlyReviewJournalsScenerio4() {
		List<JournalRankObject> result = service.journalsRank(inputScenerio4);
		compareResultList(shouldResultScenerio4, result);
	}

	@Test
	public void emptyInputSetJournalsScenerio5() {
		List<JournalRankObject> result = service.journalsRank(new HashSet<>());
		compareResultList(new ArrayList<>(), result);
	}

	private void compareResultList(List<JournalRankObject> expectd, List<JournalRankObject> result) {
		Assert.assertEquals(expectd.size(), result.size());

		for (JournalRankObject o : result) {
			if (!expectd.contains(o)) {
				Assert.fail("Expected object was not found!");
			}
		}
	}

	private void generateScenario1() {
		Journal journal = generateJournalObject(JournalType.DEVELOPER, "Journal A", 2.2f);
		inputScenerio1.add(journal);
		shouldResultScenerio1.add(generateJournalRankObject(3, journal));

		journal = generateJournalObject(JournalType.DEVELOPER, "Journal B", 6.2f);
		inputScenerio1.add(journal);
		shouldResultScenerio1.add(generateJournalRankObject(2, journal));

		journal = generateJournalObject(JournalType.SPORT, "Journal C", 6.3f);
		inputScenerio1.add(journal);
		shouldResultScenerio1.add(generateJournalRankObject(1, journal));
	}

	private void generateScenario2() {
		Journal journal = generateJournalObject(JournalType.DEVELOPER, "Journal A", 2.2f);
		inputScenerio2.add(journal);
		shouldResultScenerio2.add(generateJournalRankObject(3, journal));

		journal = generateJournalObject(JournalType.SPORT, "Journal B", 6.2f);
		inputScenerio2.add(journal);
		shouldResultScenerio2.add(generateJournalRankObject(1, journal));

		journal = generateJournalObject(JournalType.SPORT, "Journal C", 6.2f);
		inputScenerio2.add(journal);
		shouldResultScenerio2.add(generateJournalRankObject(1, journal));
	}

	private void generateScenario3() {
		Journal journal = generateJournalObject(JournalType.REVIEW, "Journal A", 5.6f);
		inputScenerio3.add(journal);

		journal = generateJournalObject(JournalType.DEVELOPER, "Journal B", 2.4f);
		inputScenerio3.add(journal);
		shouldResultScenerio3.add(generateJournalRankObject(2, journal));

		journal = generateJournalObject(JournalType.SPORT, "Journal C", 3.1f);
		inputScenerio3.add(journal);
		shouldResultScenerio3.add(generateJournalRankObject(1, journal));
	}

	private void generateScenario4() {
		Journal journal = generateJournalObject(JournalType.REVIEW, "Journal A", 5.6f);
		inputScenerio4.add(journal);

		journal = generateJournalObject(JournalType.REVIEW, "Journal B", 2.4f);
		inputScenerio4.add(journal);

		journal = generateJournalObject(JournalType.REVIEW, "Journal C", 3.1f);
		inputScenerio4.add(journal);
	}

	private Journal generateJournalObject(JournalType type, String journalName, float score) {
		return JournalFactory.getInstance().create(type, journalName, score);
	}

	private JournalRankObject generateJournalRankObject(int rankPosition, Journal journal) {
		return new JournalRankObject(rankPosition, journal);
	}
}
