public class SystemeEvenements {
    public static void main(String[] args) {
        Bouton btn = new Bouton("Valider");

        final int[] compteurClics = {0};

        btn.addClickListener(new ClickListener() {
            @Override
            public void onClick(int x, int y) {
                System.out.println("Clic aux coordonnees : (" + x + ", " + y + ")");
            }
        });

        btn.addClickListener(new ClickListener() {
            @Override
            public void onClick(int x, int y) {
                compteurClics[0]++;
                System.out.println("Compteur de clics : " + compteurClics[0]);
            }
        });

        btn.addKeyListener(new KeyListener() {
            @Override
            public void onKeyPress(char touche) {
                char min = Character.toLowerCase(touche);
                if (min == 'a' || min == 'e' || min == 'i' || min == 'o' || min == 'u' || min == 'y') {
                    System.out.println("Touche '" + touche + "' = voyelle");
                } else {
                    System.out.println("Touche '" + touche + "' = consonne");
                }
            }
        });

        btn.addHoverListener(new HoverListener() {
            @Override
            public void onHover(boolean entre) {
                if (entre) {
                    System.out.println("Info-bulle: Cliquez pour valider le formulaire");
                } else {
                    System.out.println("Info-bulle cachee");
                }
            }
        });

        btn.simulerSurvol(true);
        btn.simulerClic(10, 20);
        btn.simulerClic(30, 45);
        btn.simulerTouche('a');
        btn.simulerTouche('b');
        btn.simulerSurvol(false);
    }

    public static void mainLambda(String[] args) {
        Bouton btn = new Bouton("Valider");

        final int[] compteurClics = {0};

        btn.addClickListener((x, y) -> System.out.println("Clic aux coordonnees : (" + x + ", " + y + ")"));

        ClickListener compteurListener = (x, y) -> {
            compteurClics[0]++;
            System.out.println("Compteur de clics : " + compteurClics[0]);
        };
        btn.addClickListener(compteurListener);

        btn.addKeyListener(touche -> {
            char min = Character.toLowerCase(touche);
            if (min == 'a' || min == 'e' || min == 'i' || min == 'o' || min == 'u' || min == 'y') {
                System.out.println("Touche '" + touche + "' = voyelle");
            } else {
                System.out.println("Touche '" + touche + "' = consonne");
            }
        });

        btn.addHoverListener(entre -> {
            if (entre) {
                System.out.println("Info-bulle: Cliquez pour valider le formulaire");
            } else {
                System.out.println("Info-bulle cachee");
            }
        });

        btn.simulerSurvol(true);
        btn.simulerClic(5, 8);
        btn.simulerTouche('e');

        btn.removeClickListener(compteurListener);
        btn.simulerClic(99, 99);
    }
}
