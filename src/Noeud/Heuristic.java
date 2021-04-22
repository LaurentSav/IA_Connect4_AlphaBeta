package Noeud;

import Environment.Case;

public class Heuristic {
    /*
    public int EvaluationLignePossible(boolean typeJoueur, Case[][] grille) {
        int eval = 0;
        String symbolJoueur;
        if(typeJoueur){
            symbolJoueur = "1";
        }else {symbolJoueur = "2";}

        int colonne = grille[0].length;

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < colonne; j++) {
                if(grille[i][j].getSymbole().equals(" ")) {
                    //Les 4 premiers cas sont les nouveaux cas dû au Puissance 4
                    if(j-3>=0){ // dans le cas [symbol][symbol][symbol][vide]
                        if (grille[i][j - 3].getSymbole().equals(symbolJoueur) && grille[i][j - 2].getSymbole().equals(symbolJoueur) && grille[i][j - 1].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    if(j+3<colonne){ // dans le cas [vide][symbol][symbol][symbol]
                        if (grille[i][j + 1].getSymbole().equals(symbolJoueur) && grille[i][j + 2].getSymbole().equals(symbolJoueur) && grille[i][j + 3].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    if((j-1>=0) && (j+2<colonne)){ // dans le cas [symbol][vide][symbol][symbol]
                        if (grille[i][j - 1].getSymbole().equals(symbolJoueur) && grille[i][j + 1].getSymbole().equals(symbolJoueur) && grille[i][j + 2].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    if((j-2>=0) && (j+1<colonne)){ // dans le cas [symbol][symbol][vide][symbol]
                        if (grille[i][j - 2].getSymbole().equals(symbolJoueur) && grille[i][j - 1].getSymbole().equals(symbolJoueur) && grille[i][j + 1].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    // dans le cas [symbol][symbol][vide]
                    if(j-2>=0){
                        if (grille[i][j - 2].getSymbole().equals(symbolJoueur) && grille[i][j - 1].getSymbole().equals(symbolJoueur)) {
                            eval += 200;
                        }
                    }// dans le cas [vide][symbol][symbol]
                    if(j+2<colonne){
                        if (grille[i][j + 1].getSymbole().equals(symbolJoueur) && grille[i][j + 2].getSymbole().equals(symbolJoueur)) {
                            eval += 200;
                        }
                    }// dans le cas [symbol][vide][symbol]
                    if(j-1>=0 && j+1<colonne){
                        if (grille[i][j - 1].getSymbole().equals(symbolJoueur) && grille[i][j + 1].getSymbole().equals(symbolJoueur)) {
                            eval += 200;
                        }
                    }// dans le cas [symbol][vide]
                    if(j-1>=0){
                        if (grille[i][j - 1].getSymbole().equals(symbolJoueur)) {
                            eval += 30;
                        }
                    }// dans le cas [vide][symbol]
                    if(j+1<colonne){
                        if (grille[i][j + 1].getSymbole().equals(symbolJoueur)) {
                            eval += 30;
                        }
                    }
                }
            }
        }
        return eval;
    }
    public int EvaluationColonnePossible(boolean typeJoueur, Case[][] grille){
        int eval = 0;
        String symbolJoueur;
        if(typeJoueur){
             symbolJoueur = "1";
        }else { symbolJoueur = "2";}

        int ligne = grille.length;

        for (int i = ligne-1; i >=0; i--) {
            for (int j = 0; j < grille[0].length; j++) {
                if(grille[i][j].getSymbole().equals(" ")) {
                    // les 4 premiers cas sont les nouveaux cas du au Puissance 4
                    if(i-3>=0){ // dans le cas [symbol][symbol][symbol][vide] vertical
                        if (grille[i - 3][j].getSymbole().equals(symbolJoueur) && grille[i - 2][j].getSymbole().equals(symbolJoueur) && grille[i - 1][j].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    if(i+3<ligne){ // dans le cas [vide][symbol][symbol][symbol] vertical
                        if (grille[i + 1][j].getSymbole().equals(symbolJoueur) && grille[i + 2][j].getSymbole().equals(symbolJoueur) && grille[i + 3][j].getSymbole().equals(symbolJoueur) ){
                            eval+=1000;
                        }
                    }
                    if((i-1>=0) && (i+2<ligne)){ // dans le cas [symbol][vide][symbol][symbol] vertical
                        if (grille[i - 1][j].getSymbole().equals(symbolJoueur)  && grille[i + 1][j].getSymbole().equals(symbolJoueur) && grille[i + 2][j].getSymbole().equals(symbolJoueur) ){
                            eval+=1000;
                        }
                    }
                    if((i-2>=0) && (i+1<ligne)){ // dans le cas [symbol][symbol][vide][symbol] vertical
                        if (grille[i - 2][j].getSymbole().equals(symbolJoueur) && grille[i - 1][j].getSymbole().equals(symbolJoueur) && grille[i + 1][j].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    // dans le cas [symbol][symbol][vide] vertical
                    if(i-2>=0){
                        if (grille[i - 2][j].getSymbole().equals(symbolJoueur) && grille[i - 1][j].getSymbole().equals(symbolJoueur)) {
                            eval += 200;
                        }
                    }// dans le cas [vide][symbol][symbol] vertical
                    if(i+2<ligne){
                        if (grille[i + 1][j].getSymbole().equals(symbolJoueur) && grille[i + 2][j].getSymbole().equals(symbolJoueur)) {
                            eval += 200;
                        }
                    }// dans le cas [symbol][vide][symbol] vertical
                    if(i-1>=0 && i+1<ligne){
                        if (grille[i - 1][j].getSymbole().equals(symbolJoueur) && grille[i + 1][j].getSymbole().equals(symbolJoueur) ) {
                            eval += 200;
                        }
                    }// dans le cas [vide][symbol] vertical
                    if(i+1<ligne){
                        if (grille[i + 1][j].getSymbole().equals(symbolJoueur)) {
                            eval += 30;
                        }
                    }
                }
            }
        }
        return eval;
    }
    public int EvaluationDiagonaleDroitePossible(boolean typeJoueur, Case[][] grille){
        int eval = 0;
        String symbolJoueur;
        if(typeJoueur){ symbolJoueur = "1";
        }else {symbolJoueur = "2";}
        int ligne = grille.length;
        int colonne = grille[0].length;
        for (int i = ligne-1; i >=0; i--) {
            for (int j = 0; j < colonne; j++) {
                if(grille[i][j].getSymbole().equals(" ")) {
                    // les 4 premiers cas sont les nouveaux cas du au Puissance 4
                    if((i-3>=0) && (j-3>=0)){ // dans le cas [symbol][symbol][symbol][vide] diagonale droite
                        if (grille[i-3][j-3].getSymbole().equals(symbolJoueur) && grille[i-2][j-2].getSymbole().equals(symbolJoueur) && grille[i-1][j-1].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    if((i-3>=0) && (j+3<colonne)){ // dans le cas [vide][symbol][symbol][symbol] diagonale droite
                        if (grille[i-1][j+1].getSymbole().equals(symbolJoueur) && grille[i-2][j+2].getSymbole().equals(symbolJoueur) && grille[i-3][j+3].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    if((i+1<ligne) && (i-2>=0) && (j-1>=0) && (j+2)<colonne){ // dans le cas [symbol][vide][symbol][symbol] diagonale droite
                        if (grille[i+1][j-1].getSymbole().equals(symbolJoueur) && grille[i-1][j+1].getSymbole().equals(symbolJoueur) && grille[i-2][j+2].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    if((i+2<ligne) && (i-1>=0) && (j-2>=0) && (j+1<colonne)){ // dans le cas [symbol][symbol][vide][symbol] diagonale droite
                        if (grille[i+2][j-2].getSymbole().equals(symbolJoueur) && grille[i+1][j-1].getSymbole().equals(symbolJoueur) && grille[i-1][j+1].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    // dans le cas [symbol][symbol][vide] diagonale droite
                    if((i+2<ligne) && (j-2>=0)){
                        if (grille[i+2][j-2].getSymbole().equals(symbolJoueur) && grille[i+1][j-1].getSymbole().equals(symbolJoueur)) {
                            eval += 200;
                        }
                    }// dans le cas [vide][symbol][symbol] diagonale droite
                    if((i-2>=0) && (j+2<colonne)){
                        if (grille[i-1][j+1].getSymbole().equals(symbolJoueur) && grille[i-2][j+2].getSymbole().equals(symbolJoueur)) {
                            eval += 200;
                        }
                    }// dans le cas [symbol][vide][symbol] diagonale droite
                    if(i-1>=0 && i+1<ligne && j-1>=0 && j+1<colonne){
                        if (grille[i+1][j-1].getSymbole().equals(symbolJoueur) && grille[i-1][j+1].getSymbole().equals(symbolJoueur)) {
                            eval += 200;
                        }
                    }// dans le cas [symbol][vide] diagonale droite
                    if(i+1<ligne && j-1>=0){
                        if (grille[i+1][j-1].getSymbole().equals(symbolJoueur)) {
                            eval += 30;
                        }
                    }// dans le cas [vide][symbol] diagonale droite
                    if(i-1>=0 && j+1<colonne){
                        if (grille[i-1][j+1].getSymbole().equals(symbolJoueur)) {
                            eval += 30;
                        }
                    }
                }
            }
        }
        return eval;
    }
    public int EvaluationdiagonaleGauchePossible(boolean typeJoueur, Case[][] grille){
        int eval = 0;
        String symbolJoueur;
        if(typeJoueur){ symbolJoueur = "1";
        }else {symbolJoueur = "2";}
        int ligne = grille.length;
        int colonne = grille[0].length;
        for (int i = ligne-1; i >=0; i--) {
            for (int j = 0; j < colonne; j++) {
                if(grille[i][j].getSymbole().equals(" ")) {
                    // les 4 premiers cas sont les nouveaux cas du au Puissance 4
                    if((i+3<ligne) && (j-3>=0)){ // dans le cas [symbol][symbol][symbol][vide] diagonale gauche
                        if (grille[i+3][j-3].getSymbole().equals(symbolJoueur) && grille[i+2][j-2].getSymbole().equals(symbolJoueur) && grille[i+1][j-1].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    if((i+3<ligne) && (j+3<colonne)){ // dans le cas [vide][symbol][symbol][symbol] diagonale gauche
                        if (grille[i+1][j+1].getSymbole().equals(symbolJoueur) && grille[i+2][j+2].getSymbole().equals(symbolJoueur) && grille[i+3][j+3].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    if((i-1>=0) && (i+2<ligne) && (j-1>=0) && (j+2)<colonne){ // dans le cas [symbol][vide][symbol][symbol] diagonale gauche
                        if (grille[i-1][j-1].getSymbole().equals(symbolJoueur) && grille[i+1][j+1].getSymbole().equals(symbolJoueur) && grille[i+2][j+2].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    if((i-2>=0) && (i+1<ligne) && (j-2>=0) && (j+1<colonne)){ // dans le cas [symbol][symbol][vide][symbol] diagonale gauche
                        if (grille[i-2][j-2].getSymbole().equals(symbolJoueur) && grille[i-1][j-1].getSymbole().equals(symbolJoueur) && grille[i+1][j+1].getSymbole().equals(symbolJoueur)){
                            eval+=1000;
                        }
                    }
                    // dans le cas [symbol][symbol][vide] diagonale gauche
                    if((i-2>=0) && (j-2>=0)){
                        if (grille[i-2][j-2].getSymbole().equals(symbolJoueur) && grille[i-1][j-1].getSymbole().equals(symbolJoueur)) {
                            eval += 200;
                        }
                    }// dans le cas [vide][symbol][symbol] diagonale gauche
                    if((i+2<ligne) && (j+2<colonne)){
                        if (grille[i+1][j+1].getSymbole().equals(symbolJoueur) && grille[i+2][j+2].getSymbole().equals(symbolJoueur)) {
                            eval += 200;
                        }
                    }// dans le cas [symbol][vide][symbol] diagonale gauche
                    if(i-1>=0 && i+1<ligne && j-1>=0 && j+1<colonne){
                        if (grille[i-1][j-1].getSymbole().equals(symbolJoueur) && grille[i+1][j+1].getSymbole().equals(symbolJoueur)) {
                            eval += 200;
                        }
                    }// dans le cas [symbol][vide] diagonale gauche
                    if(i-1>=0&& j-1>=0){
                        if (grille[i-1][j-1].getSymbole().equals(symbolJoueur)) {
                            eval += 30;
                        }
                    }// dans le cas [vide][symbol] diagonale gauche
                    if(i+1<ligne && j+1<colonne){
                        if (grille[i+1][j+1].getSymbole().equals(symbolJoueur)) {
                            eval += 30;
                        }
                    }
                }
            }
        }
        return eval;
    }*/

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

    public int EvaluationFull(boolean typeJoueur, Case[][] grille){

        int joueur = 1;
        if(!typeJoueur){
            joueur = 2;
        }

        int somme = 0;

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                somme += EvaluationCalculate(EvaluationColumnFull(i,j,joueur,grille));
                somme += EvaluationCalculate(EvaluationLigneFull(i,j,joueur,grille));
                somme += EvaluationCalculate(EvaluationDiagonaleDroiteFull(i,j,joueur,grille));
                somme += EvaluationCalculate(EvaluationDiagonaleGaucheFull(i,j,joueur,grille));
            }
        }
        return somme;
    }

    public int Evaluation(Case[][] grille){

        return - EvaluationFull(false, grille) + EvaluationFull(true, grille);

    }

}
