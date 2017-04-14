
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import persons.IPerson;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 *
 * Created by jeremy on 29/03/2017.
 */

public class OutilPersonTest {

    private List<IPerson> persons;
    private GregorianCalendar gregorianCalendar;

    @Before
    public void setUp() {
        persons = new ArrayList<IPerson>();
        gregorianCalendar = new GregorianCalendar(2017,4,5);

        persons.add(generateMock(22,"jeremy","dolle"));
        persons.add(generateMock(40,"mel","petit"));

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
    public void AnonymousTest()
    {
        for (int i = 0; i < persons.size() ; i++) {
            verify(persons.get(i),never()).getFirstName();
            verify(persons.get(i),never()).getName();
        }
    }

    private IPerson generateMock(int age, String name, String lastName){
        IPerson person = Mockito.mock(IPerson.class);
        Mockito.when(person.getAge((GregorianCalendar) anyObject())).thenReturn(age);
        Mockito.when(person.getFirstName()).thenReturn(name);
        Mockito.when(person.getName()).thenReturn(lastName);
        return person;
    }

}
