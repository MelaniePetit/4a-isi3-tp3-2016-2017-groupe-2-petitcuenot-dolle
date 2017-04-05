import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import persons.IPerson;
import persons.Person;

import java.util.GregorianCalendar;

public class PersonneTest {

	private IPerson person;

	public void setPerson(IPerson person) {
		this.person = person;
	}

	@Before
	public void setUp(){
		person = new Person("PETITCUENOT", "Melanie", new GregorianCalendar(1995, 3, 17));
	}

	@Test
	public void test(){
		assertThat(true).isTrue();
	}

	@Test
	public void wasBornTrueTest() {
		assertTrue(person.wasBorn(new GregorianCalendar(1995, 3, 17)));      // Exact Date
		assertTrue(person.wasBorn(new GregorianCalendar(2016, 2, 29)));      // After Date + Bisextil
		assertTrue(person.wasBorn(new GregorianCalendar(2017, 12, 10)));     // GregorianCalendar month +1
	}

	@Test
	public void wasBornFalseTest()
	{
		assertFalse(person.wasBorn(new GregorianCalendar(1993, 5, 28)));     // Before Date
	}

	@Test
	public void getAgeTrueTest(){
		assertTrue(person.getAge(new GregorianCalendar(2017,3,29)) == 22);     //
		assertTrue(person.getAge(new GregorianCalendar(1995,3,17)) == 0);
		assertFalse(person.getAge(new GregorianCalendar(1995, 3, 17)) == 0);
	}

	@Test
	public void getAgeFalseTest(){
		assertFalse(person.getAge(new GregorianCalendar(2017,3,29)) == 12);
		assertFalse(person.getAge(new GregorianCalendar(2017,3,29)) == 100);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getAgeExceptionTest(){
		assertThat(person.getAge(new GregorianCalendar(1955,3,17)) == 0);
	}
}
