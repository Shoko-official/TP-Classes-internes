import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class GestionnaireStock {

    private List<Produit> stock = new ArrayList<>();

    public void ajouterProduit(Produit p) {
        this.stock.add(p);
    }

    public List<Produit> filtrerEtTrier(String categorie, double prixMax, int quantiteMin) {
        
        abstract class Filtre {
            abstract boolean accepter(Produit p);
        }

        class FiltreCompose extends Filtre {
            @Override
            boolean accepter(Produit p) {
                return p.categorie.equalsIgnoreCase(categorie) && p.prix <= prixMax && p.quantite >= quantiteMin;
            }
        }

        FiltreCompose filtre = new FiltreCompose();
        List<Produit> resultat = new ArrayList<>();

        for (Produit p : stock) {
            if (filtre.accepter(p)) {
                resultat.add(p);
            }
        }

        resultat.sort(new Comparator<Produit>() {
            @Override
            public int compare(Produit p1, Produit p2) {
                return Double.compare(p1.prix, p2.prix);
            }
        });
        
        return resultat;
    }
}