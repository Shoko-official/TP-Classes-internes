public class Produit {
    public final String nom;
    public final String categorie;
    public final double prix;
    public final int quantite;

    public Produit(String nom, String categorie, double prix, int quantite) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return String.format("Produit(nom=%s, categorie=%s, prix=%.2f, quantite=%d)", nom, categorie, prix, quantite);
    }
}