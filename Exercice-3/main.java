import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestionnaireStock gestionnaire = new GestionnaireStock();

        gestionnaire.ajouterProduit(new Produit("Ordi", "Electronique", 1200.0, 5));
        gestionnaire.ajouterProduit(new Produit("Souris", "Electronique", 25.0, 50));
        gestionnaire.ajouterProduit(new Produit("Clavier", "Electronique", 45.0, 30));
        gestionnaire.ajouterProduit(new Produit("Ecran", "Electronique", 200.0, 10));
        gestionnaire.ajouterProduit(new Produit("Pomme", "Alimentaire", 0.5, 100));
        gestionnaire.ajouterProduit(new Produit("Grenade", "Alimentaire", 1.2, 20));
        gestionnaire.ajouterProduit(new Produit("Chaise", "Mobilier", 85.0, 8));
        gestionnaire.ajouterProduit(new Produit("Bureau", "Mobilier", 150.0, 3));

        List<Produit> elec = gestionnaire.filtrerEtTrier("Electronique", 100.0, 15);
        for (Produit p : elec) {
            System.out.println(p);
        }

        List<Produit> mobilier = gestionnaire.filtrerEtTrier("Mobilier", 200.0, 2);
        for (Produit p : mobilier) {
            System.out.println(p);
        }
    }
}