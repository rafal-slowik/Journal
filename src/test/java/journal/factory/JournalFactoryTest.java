/**
 * 
 */
package journal.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import journal.factory.JournalFactory.JournalType;

/**
 * @author Rafal Slowik
 * @date 9 Mar 2017
 *
 */
public class JournalFactoryTest {

	private JournalFactory factory;

	@Before
	public void init() {
		factory = JournalFactory.getInstance();
	}

	@Test
	public void checkIfSingleton() {
		if (factory != JournalFactory.getInstance()) {
			Assert.fail("Factory should be singleton!");
		}
	}

	@Test
	public void nullInputJournalType() {
		try {
			factory.create(null, "Abc", 2.2f);
			Assert.fail("There was wrong input type and the factory shuld throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// OK
		}
	}
	
	@Test
	public void nullInputJournalName() {
		try {
			factory.create(JournalType.DEVELOPER, null, 2.2f);
			Assert.fail("There was wrong input value for the journal name");
		} catch (IllegalArgumentException e) {
			// OK
		}
	}
}
