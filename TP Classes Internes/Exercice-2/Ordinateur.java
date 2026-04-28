public final class Ordinateur {
    private final String marque;
    private final String processeur;
    private final int ramGo;
    private final int stockageGo;
    private final boolean ssd;
    private final String carteGraphique;
    private final double prixEuros;

    private Ordinateur(Builder builder) {
        this.marque = builder.marque;
        this.processeur = builder.processeur;
        this.ramGo = builder.ramGo;
        this.stockageGo = builder.stockageGo;
        this.ssd = builder.ssd;
        this.carteGraphique = builder.carteGraphique;
        this.prixEuros = builder.prixEuros;
    }

    @Override
    public String toString() {
        return String.format("Spec de l'ordinateur : Marque=%s, CPU=%s, RAM=%dGB, Stockage=%dGB, SSD=%b, GPU=%s, Prix=%.2fe",
                marque, processeur, ramGo, stockageGo, ssd, carteGraphique, prixEuros);
    }

    public static class Builder {
        private final String marque;
        private final String processeur;
        private final int ramGo;

        private int stockageGo = 256;
        private boolean ssd = true;
        private String carteGraphique = "Integree";
        private double prixEuros = 0.0;

        public Builder(String marque, String processeur, int ramGo) {
            this.marque = marque;
            this.processeur = processeur;
            this.ramGo = ramGo;
        }

        public Builder setStockageGo(int stockageGo) {
            this.stockageGo = stockageGo;
            return this;
        }

        public Builder setSsd(boolean ssd) {
            this.ssd = ssd;
            return this;
        }

        public Builder setCarteGraphique(String carteGraphique) {
            this.carteGraphique = carteGraphique;
            return this;
        }

        public Builder setPrixEuros(double prixEuros) {
            this.prixEuros = prixEuros;
            return this;
        }

        public Ordinateur build() {
            if (this.ramGo < 4) {
                throw new IllegalArgumentException("La RAM doit faire tourner Windows.. cordialement");
            }
            return new Ordinateur(this);
        }
    }

    public static void main(String[] args) {
        Ordinateur mid = new Ordinateur.Builder("Apple", "M3", 16).setPrixEuros(1399.99).build();

        Ordinateur cher = new Ordinateur.Builder("ASUS, MSI, NVIDIA", "AMD Ryzen 7 Ultra", 64).setStockageGo(5000).setCarteGraphique("RTX 5080").setPrixEuros(3499.99).build();

        System.out.println(mid);
        System.out.println(cher);
    }
}