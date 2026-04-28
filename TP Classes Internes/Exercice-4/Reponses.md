### Question 1 :

@FunctionalInterface n'est pas obligatoire pour compiler.
Le code marche aussi sans (il sert juste à vérifier que l'interface a une seule méthode abstraite).

Son role est de securiser l'interface: elle doit contenir une seule methode abstraite.
Si on ajoute une 2e methode abstraite, le compilateur leve une erreur.

---

### Question 2 :

Cas 1 : quand on veut definir des champs ou du vrai etat local dans le listener.
Avec une classe anonyme on peut faire:

```java
btn.addClickListener(new ClickListener() {
    private int localCount = 0;

    @Override
    public void onClick(int x, int y) {
        localCount++;
        System.out.println(localCount);
    }
});
```

Cas 2 : quand on veut redefinir plusieurs methodes d'une classe abstraite (ou d'une interface non fonctionnelle).
Un lambda ne peut cibler qu'une interface fonctionnelle, pas une classe abstraite.

```java
java.util.TimerTask task = new java.util.TimerTask() {
    @Override
    public void run() {
        System.out.println("Travail en cours");
    }
};
```

---

### Question bonus :

Le removeListener est implemente dans Bouton avec List.remove(listener).

Le probleme avec les lambdas:
si on ecrit deux fois le meme lambda inline, ce ne sont pas forcement la meme reference objet,
donc la suppression peut echouer.

Mauvais exemple:

```java
btn.addClickListener((x, y) -> System.out.println("test"));
btn.removeClickListener((x, y) -> System.out.println("test"));
```

Contournement:
stocker le lambda dans une variable puis reutiliser exactement cette reference.

```java
ClickListener l = (x, y) -> System.out.println("test");
btn.addClickListener(l);
btn.removeClickListener(l);
```
