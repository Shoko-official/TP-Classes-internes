import java.util.ArrayList;
import java.util.List;

public class Bouton {
    private String label;
    private List<ClickListener> clickListeners = new ArrayList<>();
    private List<KeyListener> keyListeners = new ArrayList<>();
    private List<HoverListener> hoverListeners = new ArrayList<>();

    public Bouton(String label) {
        this.label = label;
    }

    public void addClickListener(ClickListener listener) {
        this.clickListeners.add(listener);
    }

    public void addKeyListener(KeyListener listener) {
        this.keyListeners.add(listener);
    }

    public void addHoverListener(HoverListener listener) {
        this.hoverListeners.add(listener);
    }

    public void removeClickListener(ClickListener listener) {
        this.clickListeners.remove(listener);
    }

    public void removeKeyListener(KeyListener listener) {
        this.keyListeners.remove(listener);
    }

    public void removeHoverListener(HoverListener listener) {
        this.hoverListeners.remove(listener);
    }

    public void simulerClic(int x, int y) {
        System.out.println("[" + label + "] clic detecte");
        for (ClickListener listener : clickListeners) {
            listener.onClick(x, y);
        }
    }

    public void simulerTouche(char c) {
        System.out.println("[" + label + "] touche detectee");
        for (KeyListener listener : keyListeners) {
            listener.onKeyPress(c);
        }
    }

    public void simulerSurvol(boolean entre) {
        System.out.println("[" + label + "] survol detecte");
        for (HoverListener listener : hoverListeners) {
            listener.onHover(entre);
        }
    }
}
