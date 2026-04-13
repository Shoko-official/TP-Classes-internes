### Question 1 :

Le Builder doit être static car il doit être instancié avant l'objet final. 
S'il était une simple classe interne, il aura besoin d'une instance de Ordinateur 
pour exister alors qu'il es censé la créer lui même.

---

### Question 2 :

C'est le fait d'empiler des constructeurs avec de plus en plus de paramètres. C'est illisible et risqué (confusion entre paramètres de même type).

Exemple :
```java
public Ordinateur(String m, String p, int r) { }
public Ordinateur(String m, String p, int r, int s) { }
public Ordinateur(String m, String p, int r, int s, boolean ssd) { }
```

---

### Question 3 :

Map.Entry : Représente une paire clé-valeur dans une Map.
Stream.Builder : Il permet de construire un Stream de manière itérative avec des add().