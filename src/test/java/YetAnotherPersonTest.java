import people.SmallCodePerson;
import people.YetAnotherPerson;

/**
 * Created by jeremy on 29/03/2017.
 */
public class YetAnotherPersonTest extends PersonneTest {
    @Override
    public void setUp() {
        super.setPerson(new YetAnotherPerson("PETITCUENOT","Melanie",1995,3,17));
    }
}
