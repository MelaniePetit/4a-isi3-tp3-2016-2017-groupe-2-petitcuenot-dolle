**DOLLE Jérémy**

**PETITCUENOT Mélanie**

# Rapport TP3

# Tests boite noire

## Question 1 :

Nous avons réalisé l'analyse partionnelle suivant pour chaque classe :
- **Méthode wasBorn()** :
    - Dates retournant un résultat vrai (après la date de naissance)
    - Dates retournant un resultat faux (avant la date de naissance)
    
- **Méthode getAge()** :
    - Dates retournant un résultat vrai (test avec age correct)
    - Dates retournant un resultat faux (test avec age incorrect)
    - Dates retournant une exception (mois > 12, jour > 31)

## Question 2 :

 _différentes methodes de test :_
```java
        @Test
	public void wasBornTrueTest() {
		assertTrue(person.wasBorn(new GregorianCalendar(1995, 3, 17)));      // Exact Date
		assertTrue(person.wasBorn(new GregorianCalendar(2016, 2, 29)));      // After Date + Bisextil
		assertTrue(person.wasBorn(new GregorianCalendar(2017, 12, 10)));     // GregorianCalendar month +1
	}

	@Test
	public void wasBornFalseTest()
	{
		assertFalse(person.wasBorn(new GregorianCalendar(1993, 5, 28)));     // Before Date
	}

	@Test
	public void getAgeTrueTest(){
		assertTrue(person.getAge(new GregorianCalendar(2017,3,29)) == 22);     //
		assertTrue(person.getAge(new GregorianCalendar(1995,3,17)) == 0);
	}

	@Test
	public void getAgeFalseTest(){
		assertFalse(person.getAge(new GregorianCalendar(2017,3,29)) == 12);
		assertFalse(person.getAge(new GregorianCalendar(2017,3,29)) == 100);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getAgeExceptionTest(){
		assertThat(person.getAge(new GregorianCalendar(1955,3,17)) == 0);
	}
```

## Question 3 :
_Pour ce faire, il suffit de creer une classe mère qui contiendra les méthodes de test.
En y ajoutant une methode qui s'executera avant les méthodes de test grace au mot clé @before. 
Cette méthode va donc initialiser le type de personne. Ainsi, on va creer pour un type de personne,
une classe associé qui extends la classe mère et qui overide la methode setUp()._ 

```java
    public class PoeplePersonneTest extends PersonneTest{
        @Override
        public void setUp() {
            PersonneAdaptateur personneAdaptateur = new PersonneAdaptateur("PETITCUENOT","Melanie",17,3,1995);
            super.setPerson(personneAdaptateur);
        }
    }
```

## Question 4 :

_**Simple personne**_ :
 - getAgeException => exception non gérée dans le code

_**EfficientePersonTest**_ :
 - getAgeException => exception non gérée dans le code
 - wasBornFalseTest => compare l'age et ne tient pas compte de la date renseignée
 - getAgeTrueTest  => retourn l'age de la personne et ne tient pas compte de la date de référence à laquelle on souhaite connaitre l'age

_**YetAnotherPerson**_ et _**OneMorePersonn**_ : 
 - pas d'erreur : test à revoir

_**SmallCodePersonTest**_ :
 - erreur sur le test getAgeTrueTest
 
## Question 5 :

Pour ce faire, nous avons choisi d'utiliser le patron _***adaptateur***_ qui va nous permettre,
en implementant IPerson d'adapter la classe people.Personne afin de pouvoir
lui faire passer les classes de test faite précedemment. Ainsi, il suffira de faire passer l'adaptateur
dans la methodes qui initialise la personne.

```java
    @Override
    public void setUp() {
        PersonneAdaptateur personneAdaptateur = new PersonneAdaptateur("PETITCUENOT","Melanie",17,3,1995);
        super.setPerson(personneAdaptateur);
    }
```

# Tests en isolation et Mock

## Question 6 :

```java
    List<IPerson> personBetween(List<IPerson> persons, GregorianCalendar gregorianCalendar, int ageMin, int ageMax)
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
```

## Question 7 :

```java
    int recherche(List<IPerson> persons, GregorianCalendar gregorianCalendar)
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
```

## Question 8 :

```java
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
```

## Question 9 :


## Question 10 :



