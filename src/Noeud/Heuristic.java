package Noeud;

import Environment.Case;

public class Heuristic {

    public static int methode = 1;


    /*
    * Attribution d'un score en fonction du nombre de pion
     */
    public int EvaluationCalculate(int nbPion){

        if(nbPion == 1){
            return 10;
        }else if(nbPion == 2){
            return 100;
        }else if(nbPion == 3){
            return 1000;
        }else if(nbPion >= 4){
            return 10000;
        }
        return 0;
    }

    /*
     * Fonctions d'évaluation pour la méthode 2
     *
     */

    // Evaluation de la ligne en fonction des cas (voir rapport)
    // On calcule le score d'une case en fonction de quatre cas et en fonction du nombre de pions
    public int EvaluationLigne(boolean typeJoueur, Case[][] grille, int ligne, int col){

        int score = 0;
        score += EvaluationCalculate(EvaluationLigneCas1(typeJoueur, grille, ligne, col));
        score += EvaluationCalculate(EvaluationLigneCas2(typeJoueur, grille, ligne, col));
        score += EvaluationCalculate(EvaluationLigneCas3(typeJoueur, grille, ligne, col));
        score += EvaluationCalculate(EvaluationLigneCas4(typeJoueur, grille, ligne, col));
        return score;

    }
    public int EvaluationLigneCas1(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 1
        for (int i = 0; i < 4; i++) {
            if(col + i < 7){
                if(grille[ligne][col + i].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne][col + i].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }
    public int EvaluationLigneCas2(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 2
        for (int i = -1; i < 3; i++) {
            if(col + i < 7 && col + i >= 0){
                if(grille[ligne][col + i].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne][col + i].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }
    public int EvaluationLigneCas3(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 2
        for (int i = -2; i < 2; i++) {
            if(col + i < 7 && col + i >= 0){
                if(grille[ligne][col + i].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne][col + i].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }
    public int EvaluationLigneCas4(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 2
        for (int i = -3; i < 1; i++) {
            if(col + i < 7 && col + i >= 0){
                if(grille[ligne][col + i].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne][col + i].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }

    // Evaluation de la colonne en fonction des cas (voir rapport)
    // On calcule le score d'une case en fonction de quatre cas et en fonction du nombre de pions
    public int EvaluationColonne(boolean typeJoueur, Case[][] grille, int ligne, int col){

        int score = 0;
        score += EvaluationCalculate(EvaluationColonneCas1(typeJoueur, grille, ligne, col));
        score += EvaluationCalculate(EvaluationColonneCas2(typeJoueur, grille, ligne, col));
        score += EvaluationCalculate(EvaluationColonneCas3(typeJoueur, grille, ligne, col));
        score += EvaluationCalculate(EvaluationColonneCas4(typeJoueur, grille, ligne, col));
        return score;

    }
    public int EvaluationColonneCas1(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 1
        for (int i = 0; i < 4; i++) {
            if(ligne + i < 6){
                if(grille[ligne+ i][col].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne+ i][col].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }
    public int EvaluationColonneCas2(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 2
        for (int i = -1; i < 3; i++) {
            if(ligne + i < 6 && ligne + i >= 0){
                if(grille[ligne + i][col].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne + i][col].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }
    public int EvaluationColonneCas3(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 3
        for (int i = -2; i < 2; i++) {
            if(ligne + i < 6 && ligne + i >= 0){
                if(grille[ligne + i][col].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne + i][col].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }
    public int EvaluationColonneCas4(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 2
        for (int i = -3; i < 1; i++) {
            if(ligne + i < 6 && ligne + i >= 0){
                if(grille[ligne + i][col].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne + i][col].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }

    // Evaluation de la diagonale droite en fonction des cas (voir rapport)
    // On calcule le score d'une case en fonction de quatre cas et en fonction du nombre de pions
    public int EvaluationDiagonaleDroite(boolean typeJoueur, Case[][] grille, int ligne, int col){

        int score = 0;
        score += EvaluationCalculate(EvaluationDiagonaleDroiteCas1(typeJoueur, grille, ligne, col));
        score += EvaluationCalculate(EvaluationDiagonaleDroiteCas2(typeJoueur, grille, ligne, col));
        score += EvaluationCalculate(EvaluationDiagonaleDroiteCas3(typeJoueur, grille, ligne, col));
        score += EvaluationCalculate(EvaluationDiagonaleDroiteCas4(typeJoueur, grille, ligne, col));
        return score;

    }
    public int EvaluationDiagonaleDroiteCas1(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 1
        for (int i = 0; i < 4; i++) {
            if(ligne - i < 6 && col + i < 7 && ligne - i >= 0 && col +i >= 0){
                if(grille[ligne - i][col + i].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne - i][col+i].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }
    public int EvaluationDiagonaleDroiteCas2(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 2
        for (int i = -1; i < 3; i++) {
            if(ligne - i < 6 && col + i < 7 && ligne - i >= 0 && col +i >= 0){
                if(grille[ligne - i][col + i].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne - i][col+i].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }
    public int EvaluationDiagonaleDroiteCas3(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 3
        for (int i = -2; i < 2; i++) {
            if(ligne - i < 6 && col + i < 7 && ligne - i >= 0 && col +i >= 0){
                if(grille[ligne - i][col + i].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne - i][col+i].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }
    public int EvaluationDiagonaleDroiteCas4(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 2
        for (int i = -3; i < 1; i++) {
            if(ligne - i < 6 && col + i < 7 && ligne - i >= 0 && col +i >= 0){
                if(grille[ligne - i][col + i].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne - i][col+i].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }

    // Evaluation de la diagonale gauche en fonction des cas (voir rapport)
    // On calcule le score d'une case en fonction de quatre cas et en fonction du nombre de pions
    public int EvaluationDiagonaleGauche(boolean typeJoueur, Case[][] grille, int ligne, int col){

        int score = 0;
        score += EvaluationCalculate(EvaluationDiagonaleGaucheCas1(typeJoueur, grille, ligne, col));
        score += EvaluationCalculate(EvaluationDiagonaleGaucheCas2(typeJoueur, grille, ligne, col));
        score += EvaluationCalculate(EvaluationDiagonaleGaucheCas3(typeJoueur, grille, ligne, col));
        score += EvaluationCalculate(EvaluationDiagonaleGaucheCas4(typeJoueur, grille, ligne, col));
        return score;

    }
    public int EvaluationDiagonaleGaucheCas1(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 1
        for (int i = 0; i < 4; i++) {
            if(ligne + i < 6 && col + i < 7 && ligne + i >= 0 && col +i >= 0){
                if(grille[ligne + i][col+i].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne+ i][col+i].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }
    public int EvaluationDiagonaleGaucheCas2(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 2
        for (int i = -1; i < 3; i++) {
            if(ligne + i < 6 && col + i < 7 && ligne + i >= 0 && col +i >= 0){
                if(grille[ligne+ i][col+i].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne+ i][col+i].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }
    public int EvaluationDiagonaleGaucheCas3(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 3
        for (int i = -2; i < 2; i++) {
            if(ligne + i < 6 && col + i < 7 && ligne + i >= 0 && col +i >= 0){
                if(grille[ligne+ i][col+i].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne+ i][col+i].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }
    public int EvaluationDiagonaleGaucheCas4(boolean typeJoueur, Case[][] grille, int ligne, int col) {
        int nbPions = 0;
        String symbolJoueur;
        String sJsuivant;
        if(typeJoueur){
            symbolJoueur = "1";
            sJsuivant = "2";
        }else {
            symbolJoueur = "2";
            sJsuivant = "1";
        }

        //Cas position 2
        for (int i = -3; i < 1; i++) {
            if(ligne + i < 6 && col + i < 7 && ligne + i >= 0 && col +i >= 0){
                if(grille[ligne+ i][col+i].getSymbole().equals(sJsuivant)){
                    nbPions = 0;
                    break;
                }
                if(grille[ligne+ i][col+i].getSymbole().equals(symbolJoueur)){
                    nbPions++;
                }
            }else{
                nbPions = 0;
            }
        }
        return nbPions;
    }



    /*
    * Fonctions d'évaluation pour la méthode 1
     */

    /* Evaluation de la ligne, retourne le nombre de pion d'un joueur sur une ligne en fonction de la case i,j */
    public int EvaluationLigneFull(int i, int j, int player, Case[][] grille){
        int nbaligner = 0;
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
        return nbaligner;
    }

    /* Evaluation de la colonne, retourne le nombre de pion d'un joueur sur une ligne en fonction de la case i,j */
    public int EvaluationColumnFull(int i, int j, int player, Case[][] grille){
        int nbaligner = 0;
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
        return nbaligner;
    }

    /* Evaluation de la diagonal gauche, retourne le nombre de pion d'un joueur sur une ligne en fonction de la case i,j */
    public int EvaluationDiagonaleGaucheFull(int i, int j, int player, Case[][] grille){
        int nbaligner = 0;
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
        nbaligner = nbaligner - 2;
        return nbaligner;
    }

    /* Evaluation de la diagonal droite, retourne le nombre de pion d'un joueur sur une ligne en fonction de la case i,j */
    public int EvaluationDiagonaleDroiteFull(int i, int j, int player, Case[][] grille){
        int nbaligner = 0;
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
        nbaligner = nbaligner - 2;
        return nbaligner;
    }


    /* Retourne le score d'un joueur sur une grille */
    public int EvaluationFull(boolean typeJoueur, Case[][] grille){

        int joueur = 1;
        if(!typeJoueur){
            joueur = 2;
        }

        int somme = 0;

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                // Méthode 1
                if(methode == 1){
                    somme += EvaluationCalculate(EvaluationColumnFull(i,j,joueur,grille));
                    somme += EvaluationCalculate(EvaluationLigneFull(i,j,joueur,grille));
                    somme += EvaluationCalculate(EvaluationDiagonaleDroiteFull(i,j,joueur,grille));
                    somme += EvaluationCalculate(EvaluationDiagonaleGaucheFull(i,j,joueur,grille));

                }else{ // Méthode 2
                    somme += EvaluationLigne(typeJoueur, grille, i , j);
                    somme += EvaluationColonne(typeJoueur, grille, i , j);
                    somme += EvaluationDiagonaleDroite(typeJoueur, grille, i , j);
                    somme += EvaluationDiagonaleGauche(typeJoueur, grille, i , j);
                }

            }
        }
        // Pour afficher le score de la grille selon le joueur
        /*
        if(typeJoueur)
        {
            System.out.print("J1 ");
        }else{
            System.out.print("IA ");
        }

        System.out.println(somme);
        */
        return somme;
    }

    /* Retourne l'évaluation de la grille */
    public int Evaluation(Case[][] grille){

        return EvaluationFull(true, grille) - EvaluationFull(false, grille);

    }

}
