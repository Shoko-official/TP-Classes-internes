public class Robot {
    private String nom;
    private boolean allume = false;
    private int energie;
    private Bras bras = new Bras();

    public Robot(String nom, int energie) {
        this.nom = nom;
        if (energie > 100) {
            this.energie = 100;
        } else if (energie < 0) {
            this.energie = 0;
        } else {
            this.energie = energie;
        }
    }

    public void allumer() {
        this.allume = true;
    }

    public void eteindre() {
        this.allume = false;
    }

    public Bras getBras() {
        return this.bras;
    }

    public class Bras {
        public void saisir(String objet) {
            if (allume && energie > 20) {
                System.out.println("Saisie de l'objet : " + objet);
                energie -= 10;
            }
        }

        public void deposer(String objet) {
            if (allume) {
                System.out.println("Dépôt de l'objet : " + objet);
                energie -= 5;
            }
        }

        public void afficherEtat() {
            String etat;
            if (allume) {
                etat = "allumé";
            } else {
                etat = "éteint";
            }
            System.out.println("Nom : " + nom + ", énergie : " + energie + ", état : " + etat);
        }
    }

    public static void main(String[] args) {
        Robot robot = new Robot("BMO", 50);
        Robot.Bras bras = robot.getBras();

        bras.saisir("Bloc A");

        robot.allumer();
        bras.saisir("Bloc A");
        bras.deposer("Bloc A");
        bras.saisir("Bloc B");
        bras.saisir("Bloc C");
        
        bras.afficherEtat();
    }
}