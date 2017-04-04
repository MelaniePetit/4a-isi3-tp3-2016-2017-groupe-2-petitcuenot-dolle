**DOLLE Jérémy**

**PETITCUENOT Mélanie**

# Rapport TP3

## Tests boite noire

####Question 1 :

Nous avons réalisé l'analyse partionnelle suivant pour chaque classe :
- Méthode wasBorn() :
    - Dates retournant un résultat vrai (après la date de naissance)
    - Dates retournant un resultat faux (avant la date de naissance)
    
- Méthode getAge() :
    - Dates retournant un résultat vrai (test avec age correct)
    - Dates retournant un resultat faux (test avec age incorrect)
    - Dates retournant une exception (mois > 12, jour > 31)

####Question 2 :


####Question 3 :


####Question 4 :

_Simple personne_ :

getAgeException => exception non gérée dans le code

_EfficientePersonTest_ :

getAgeException => exception non gérée dans le code

wasBornFalseTest => compare l'age et ne tient pas compte de la date renseignée

getAgeTrueTest  => retourn l'age de la personne et ne tient pas compte de la date de référence à laquelle on souhaite connaitre l'age

_YetAnotherPerson_ et _OneMorePersonn_ : pas d'erreur
####Question 5 :


## Tests en isolation et Mock


####Question 6 :


####Question 7 :


####Question 8 :


####Question 9 :


####Question 10 :



