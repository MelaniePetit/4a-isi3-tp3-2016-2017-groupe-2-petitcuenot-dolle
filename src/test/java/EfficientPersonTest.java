import people.EfficientPerson;

/**
 *
 * Created by jeremy on 29/03/2017.
 */
public class EfficientPersonTest extends PersonneTest{

    @Override
    public void setUp() {
        super.setPerson(new EfficientPerson("PETITCUENOT","Melanie",22));
    }
}
