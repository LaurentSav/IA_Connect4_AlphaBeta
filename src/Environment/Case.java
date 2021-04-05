package Environment;

import java.awt.*;

public class Case {

    private Point p;
    private String symbole;
    public Case(Point p){
        this.p = p;
        symbole = " ";
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    @Override
    public String toString() {
        String affichage = "[";
        affichage += symbole;
        affichage += "]";
        return affichage;
    }
}
