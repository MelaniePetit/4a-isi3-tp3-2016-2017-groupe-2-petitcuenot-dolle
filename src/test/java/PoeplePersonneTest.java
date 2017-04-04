/**
 * Created by jeremy on 29/03/2017.
 */
public class PoeplePersonneTest extends PersonneTest{

    @Override
    public void setUp() {
        PersonneAdaptateur personneAdaptateur = new PersonneAdaptateur("PETITCUENOT","Melanie",17,3,1995);
        super.setPerson(personneAdaptateur);
    }
}
