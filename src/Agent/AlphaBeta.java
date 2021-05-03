package Agent;

import Environment.Case;
import Noeud.Noeud;

import java.awt.*;

public class AlphaBeta {

    /* Algorithme Alpha Beta */
    public Coup AlphaBeta(Noeud n, int alpha, int beta, int profondeur){

        int width = n.getGrille()[0].length;
        // Initialisation d'une copie vide de la grille
        Case[][] copie = initialisationGrille();

        if ((profondeur == 0) || (estFinJeu(n.isMax(), n.getGrille()))){
            n.evaluer();
            return new Coup(n.getH(), -1);
        }

        // Si Noeud Max
        if (n.isMax()) {
            int bestj = 0; // Meilleur Colonne
            int alphalcl = alpha; //alpha local
            for (int j = 0; j < width; j++) {
                copieMatrice(n.getGrille(), copie);  // Copie de la grille
                if (jouer(n.isMax(), j, copie)) {    // On place un pion dans une des colonnes
                    Noeud successeur = new Noeud(!n.isMax(), copie);   // Noeud enfant MIN et qui prend en parametre la copie avec le pion posé dans une des colonnes de la grille
                    Coup c2 = AlphaBeta(successeur, alphalcl, beta, profondeur - 1);     // Exécution d'alphabeta
                    successeur.setH(c2.getEval());

                    if (successeur.getH() > alphalcl) {
                        alphalcl = successeur.getH();
                        bestj = j;
                    }
                    if (alphalcl >= beta) {
                        Coup c3 = new Coup(alphalcl, bestj);
                        return c3;
                    }
                    if(alphalcl > alpha){
                        alpha = alphalcl;
                    }
                }
            }
            return new Coup(alphalcl,bestj);
        } else {
            int bestj = 0;
            int betalcl = beta; //beta local
            for (int k = 0; k < width; k++) {

                copieMatrice(n.getGrille(), copie);

                if (jouer(!n.isMax(), k, copie)){
                    Noeud successeur = new Noeud(n.isMax(), copie);
                    Coup c5 = AlphaBeta(successeur, alpha, beta, profondeur - 1);
                    successeur.setH(c5.getEval());

                    //Dans un noeud min, nous cherchons toujours à avoir le beta le plus petit
                    if (successeur.getH() < betalcl){
                        betalcl = successeur.getH();
                        bestj = k;
                    }
                    if (betalcl <= alpha) {
                        Coup c6 = new Coup(betalcl, bestj);
                        return c6;
                    }
                    if(betalcl > beta){
                        beta = betalcl;
                    }
                }
            }
            return new Coup(betalcl, bestj);
        }
    }

    public void copieMatrice(Case[][] grille, Case[][] grillecopie){
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                grillecopie[i][j].setP(grille[i][j].getP());
                grillecopie[i][j].setSymbole(grille[i][j].getSymbole());
            }
        }
    }

    public boolean jouer(boolean typeJoueur, int colonne, Case[][] grille){
        int symbol;
        if (typeJoueur) {
            symbol = 1;
        } else {
            symbol = 2;
        }

        if(checkColonneFull(colonne, grille)){
            return false;
        }

        return placerPions(symbol, colonne, grille);

    }

    public boolean checkColonneFull(int colonne, Case[][] grille){

        if(!grille[0][colonne].getSymbole().equals(" ")){
            return true;
        }
        return false;

    }

    public boolean placerPions(int joueur, int colonne, Case[][] grille){
        for (int i = grille.length-1; i >= 0; i--) {
            if(grille[i][colonne].getSymbole().equals(" ")){
                switch (joueur) {
                    case 1 -> grille[i][colonne].setSymbole("1");
                    case 2 -> grille[i][colonne].setSymbole("2");
                }
                return true;
            }
        }
        return false;
    }

    public boolean EvaluationLigneFull(int i, int j, int player, Case[][] grille){
        int nbaligner = 1;
        String numPlayer = String.valueOf(player);

        //Ligne Gauche
        for (int k = j; k >= 0; k--) {
            if(grille[i][j].getSymbole().equals(numPlayer)){
                if(grille[i][k].getSymbole().equals(numPlayer)){
                    nbaligner++;
                }else{
                    break;
                }
            }
        }

        //Ligne Droite
        for (int k = j; k < grille[0].length; k++) {
            if(grille[i][j].getSymbole().equals(numPlayer)){
                if(grille[i][k].getSymbole().equals(numPlayer)){
                    nbaligner++;
                }else{
                    break;
                }
            }
        }
        nbaligner = nbaligner - 2;
        return nbaligner >= 4;
    }

    public boolean EvaluationColumnFull(int i, int j, int player, Case[][] grille){
        int nbaligner = 1;
        String numPlayer = String.valueOf(player);
        //Colonne Haut
        for (int k = i; k >= 0; k--) {
            if(grille[i][j].getSymbole().equals(numPlayer)){
                if(grille[k][j].getSymbole().equals(numPlayer)){
                    nbaligner++;
                }else{
                    break;
                }
            }
        }

        //Ligne Bas
        for (int k = i; k < grille.length; k++) {
            if(grille[i][j].getSymbole().equals(numPlayer)){
                if(grille[k][j].getSymbole().equals(numPlayer)){
                    nbaligner++;
                }else{
                    break;
                }
            }
        }
        nbaligner = nbaligner - 2;
        return nbaligner >= 4;
    }

    public boolean EvaluationDiagonaleGaucheFull(int i, int j, int player, Case[][] grille){
        int nbaligner = 1;
        String numPlayer = String.valueOf(player);
        //Diagonale Haut-Gauche
        int k = i;
        int l = j;
        while(k > 0 && l > 0){
            k--;
            l--;
            if(grille[i][j].getSymbole().equals(numPlayer)){
                if(grille[k][l].getSymbole().equals(numPlayer)){
                    nbaligner++;
                }else{
                    break;
                }
            }
        }

        //Diagonale Bas-Droite
        k = i;
        l = j;
        while(k < grille.length - 1 && l < grille[0].length - 1){
            k++;
            l++;
            if(grille[i][j].getSymbole().equals(numPlayer)){
                if(grille[k][l].getSymbole().equals(numPlayer)){
                    nbaligner++;
                }else{
                    break;
                }
            }
        }

        return nbaligner >= 4;
    }

    public boolean EvaluationDiagonaleDroiteFull(int i, int j, int player, Case[][] grille){
        int nbaligner = 1;
        String numPlayer = String.valueOf(player);
        //Diagonale Haut-Droite
        int k = i;
        int l = j;
        while(k > 0 && l < grille[0].length - 1){
            k--;
            l++;
            if(grille[i][j].getSymbole().equals(numPlayer)){
                if(grille[k][l].getSymbole().equals(numPlayer)){
                    nbaligner++;
                }else{
                    break;
                }
            }
        }

        // Diagonale Bas-Gauche
        k = i;
        l = j;
        while(k < grille.length - 1 && l > 0){
            k++;
            l--;
            if(grille[i][j].getSymbole().equals(numPlayer)){
                if(grille[k][l].getSymbole().equals(numPlayer)){
                    nbaligner++;
                }else{
                    break;
                }
            }
        }

        return nbaligner >= 4;
    }

    public int EvaluationFull(boolean typeJoueur, Case[][] grille){

        int joueur = 1;
        if(typeJoueur){
            joueur = 1;
        }else{
            joueur = 2;
        }

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                if(EvaluationLigneFull(i,j,joueur, grille)){
                    return 1000;
                }
                if(EvaluationColumnFull(i,j,joueur, grille)){
                    return 1000;
                }
                if(EvaluationDiagonaleDroiteFull(i,j,joueur,grille)){
                    return 1000;
                }
                if(EvaluationDiagonaleGaucheFull(i,j,joueur,grille)){
                    return 1000;
                }
            }
        }
        return 0;
    }

    public boolean estFinJeu(boolean typeJoueur, Case[][] grille){
        if(EvaluationFull(typeJoueur, grille) == 1000){
            return true;
        }
        return false;
    }

    public Case[][] initialisationGrille(){
        Case[][] grille = new Case[6][7];
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                grille[i][j] = new Case(new Point(i,j));
            }
        }
        return grille;
    }


}
