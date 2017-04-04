import people.Personne;
import persons.IPerson;

import java.util.GregorianCalendar;

/**
 *
 * Created by jeremy on 29/03/2017.
 */
public class PersonneAdaptateur implements IPerson {

    private Personne personne;

    public Personne getPersonne() {
        return personne;
    }

    public PersonneAdaptateur(String name, String lastname, int month, int day, int year) {
        this.personne = new Personne(lastname,name,day,month,year);
    }

    public String getName() {
        return getPersonne().getName();
    }

    public String getFirstName() {
        return getPersonne().getFirstName();
    }

    public boolean wasBorn(GregorianCalendar gregorianCalendar) {
        return getAge(gregorianCalendar) >= 0;
    }

    public int getAge(GregorianCalendar gregorianCalendar) {
        return getPersonne().getAge(gregorianCalendar);
    }
}
