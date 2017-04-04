import people.OneMorePerson;

/**
 *
 * Created by jeremy on 29/03/2017.
 */
public class OneMorePersonTest extends PersonneTest {

    @Override
    public void setUp() {
        super.setPerson(new OneMorePerson("PETITCUENOT","Melanie",1995,3,17));
    }
}
