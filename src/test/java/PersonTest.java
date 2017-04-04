import people.EfficientPerson;
import persons.Person;

/**
 * Created by jeremy on 29/03/2017.
 */
public class PersonTest extends PersonneTest {
    @Override
    public void setUp() {
        super.setPerson(new Person("PETITCUENOT","Melanie",1995,3,17));
    }
}
