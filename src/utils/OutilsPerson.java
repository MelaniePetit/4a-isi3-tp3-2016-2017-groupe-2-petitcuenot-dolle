import persons.IPerson;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by jeremy on 29/03/2017.
 */
public class OutilsPerson {

    public static List<IPerson> personBetween(List<IPerson> persons, GregorianCalendar gregorianCalendar,int ageMin, int ageMax)
    {
        List<IPerson> includedPersons = new ArrayList<IPerson>();
        if (ageMin>ageMax)
            throw new IllegalArgumentException("Illegal");

        for(IPerson person : persons)
        {
            if(person.getAge(gregorianCalendar) > ageMin && person.getAge(gregorianCalendar) < ageMax)
                includedPersons.add(person);
        }

        return includedPersons;
    }

    public static int recherche(List<IPerson> persons, GregorianCalendar gregorianCalendar)
    {
        int maxAge = 0;

        if(persons.isEmpty())
            return -1;

        for (IPerson person : persons)
        {
            if(person.getAge(gregorianCalendar)>maxAge)
                maxAge = person.getAge(gregorianCalendar);
        }

        return maxAge;
    }

}
