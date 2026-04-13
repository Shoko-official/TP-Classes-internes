### Question 1 : Accès aux champs privés

La classe interne peut accéder aux champs privés car elle appartient 
au même bloc de code que la classe Robot. 
En Java, une classe interne membre est liée à une instance de la classe 
externe et possède une référence cachée 
vers celle-ci, ce qui lui donne les pleins droits sur ses variables.

---

### Question 2 : Instanciation depuis l'extérieur

La syntaxe est la suivante :

```java
Robot.Bras monBras = monRobot.new Bras();
```

C'est différent car le Bras a besoin d'exister à l'intérieur d'un Robot spécifique. 
On ne peut pas créer de bras "volant" sans l'attacher à une instance de robot déjà créée.


### Question 3 : Distinction des champs (Shadowing)

On utilise le nom de la classe suivi de .this pour désigner le robot.
Java

```java
public class Bras {
    private int energie = 10;s

    public void afficher() {
        System.out.println(this.energie);
        System.out.println(Robot.this.energie);
    }
}
```