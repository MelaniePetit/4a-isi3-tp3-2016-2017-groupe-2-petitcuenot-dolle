import org.junit.Before;
import people.SimplePerson;

/**
 *
 * Created by jeremy on 29/03/2017.
 */
public class SimplePersonTest extends PersonneTest {

    @Override
    @Before
    public void setUp() {
        super.setPerson(new SimplePerson("PETITCUENOT","Melanie",1995,3,17));
    }
}
