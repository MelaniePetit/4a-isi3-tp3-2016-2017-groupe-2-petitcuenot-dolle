import people.SmallCodePerson;

/**
 *
 * Created by jeremy on 29/03/2017.
 */
public class SmallCodePersonTest extends PersonneTest {

    @Override
    public void setUp() {
        super.setPerson(new SmallCodePerson("PETITCUENOT","Melanie",1995,3,17));
    }
}
