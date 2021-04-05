package Noeud;

import Environment.Case;

public class Noeud {

    private Case[][] grille;
    private boolean max;
    private int h;

    public Noeud(boolean max, Case[][] grille) {
        this.max = max;
        this.grille = grille;
    }

    public Case[][] getGrille() {
        return grille;
    }

    public void setGrille(Case[][] grille) {
        this.grille = grille;
    }

    public boolean isMax() {
        return max;
    }

    public void setMax(boolean max) {
        this.max = max;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void evaluer(){
        Heuristic heuristic = new Heuristic();
        this.h = heuristic.Evaluation(this.grille);
    }

    @Override
    public String toString() {
        System.out.println("L'environnement");
        String affichage = "";
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                affichage += grille[i][j].toString();
            }
            affichage += "\n";
        }

        for (int i = 0; i < grille[0].length; i++) {
            affichage += " " + i + " ";
        }
        affichage += "\n";

        return affichage;
    }
}
