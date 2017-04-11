
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import persons.IPerson;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Matchers.anyObject;

/**
 *
 * Created by jeremy on 29/03/2017.
 */

public class OutilPersonTest {

    private List<IPerson> persons;
    private List<IPerson> anonymousPersons;
    private GregorianCalendar gregorianCalendar;

    @Before
    public void setUp() {
        persons = new ArrayList<IPerson>();
        anonymousPersons = new ArrayList<IPerson>();
        gregorianCalendar = new GregorianCalendar(2017,4,5);

        persons.add(generateMock(22,"jeremy","dolle"));
        persons.add(generateMock(40,"mel","petit"));

        anonymousPersons.add(generateAnonymousMock(22));
        anonymousPersons.add(generateAnonymousMock(40));
    }

    @Test
    public void personBetweenTest() {
        assertThat(OutilsPerson.personBetween(persons,gregorianCalendar,30,45)).containsExactly(persons.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void personBetweenExceptionTest()
    {
        assertThat(OutilsPerson.personBetween(new ArrayList<IPerson>(),gregorianCalendar,50,20));
    }

    @Test
    public void rechercheTest()
    {
        assertThat(OutilsPerson.recherche(persons,gregorianCalendar)).isEqualTo(40);
    }

    @Test
    public void rechercheEmptyListTest()
    {
        assertThat(OutilsPerson.recherche(new ArrayList<IPerson>(),gregorianCalendar)).isEqualTo(-1);
    }

    @Test
    public void rechercheAnonymousTest()
    {
        assertThat(OutilsPerson.recherche(anonymousPersons,gregorianCalendar)).isEqualTo(40);
    }

    private IPerson generateMock(int age, String name, String lastName){
        IPerson person = Mockito.mock(IPerson.class);
        Mockito.when(person.getAge((GregorianCalendar) anyObject())).thenReturn(age);
        Mockito.when(person.getFirstName()).thenReturn(name);
        Mockito.when(person.getName()).thenReturn(lastName);
        return person;
    }

    private IPerson generateAnonymousMock(int age){
        IPerson person = Mockito.mock(IPerson.class);
        Mockito.when(person.getAge((GregorianCalendar) anyObject())).thenReturn(age);
        return person;
    }
}
