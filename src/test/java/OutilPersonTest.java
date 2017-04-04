import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import persons.IPerson;
import persons.Person;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 *
 * Created by jeremy on 29/03/2017.
 */
public class OutilPersonTest {
    private OutilsPerson mockOutilPerson = Mockito.mock(OutilsPerson.class);
    private List<IPerson> persons = new ArrayList<IPerson>();
    private GregorianCalendar gregorianCalendar;

    @Before
    public void setUp(){
        gregorianCalendar = new GregorianCalendar(2017,3,29);
        persons.add(generateMock(22,"jeremy","dolle"));
        persons.add(generateMock(0,"melanie","petit"));
    }

    @Test
    public void personBetweenTest()
    {
        mockOutilPerson.personBetween(persons,gregorianCalendar,10,25);
        mockOutilPerson.personBetween(persons,gregorianCalendar,0,90);
    }

    @Test(expected = IllegalArgumentException.class)
    public void personBetweenExceptionTest()
    {
        mockOutilPerson.personBetween(persons,gregorianCalendar,20,15);
    }

    @Test
    public void rechercheTest()
    {
        mockOutilPerson.recherche(persons,gregorianCalendar);
    }

    @Test
    public void rechercheEmptyListTest()
    {
        assertEquals(mockOutilPerson.recherche(new ArrayList<IPerson>(), gregorianCalendar), -1);
    }

    public IPerson generateMock(int age, String name, String lastName){
        IPerson person = Mockito.mock(Person.class);
        when(person.getAge((GregorianCalendar) anyObject())).thenReturn(age);
        when(person.getFirstName()).thenReturn(name);
        when(person.getName()).thenReturn(lastName);
        return person;
    }
}
