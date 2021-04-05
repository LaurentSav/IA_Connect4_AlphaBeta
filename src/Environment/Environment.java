package Environment;

import Agent.Agent;

import java.awt.*;
import java.util.Arrays;

public class Environment {

    private Case[][] grille;
    private Agent agent;

    public Environment(int profondeur){
        initialisationGrille();
        agent = new Agent(profondeur);

    }

    public void initialisationGrille(){
        grille = new Case[6][7];
        for (int i = 0; i < this.grille.length; i++) {
            for (int j = 0; j < this.grille[i].length; j++) {
                grille[i][j] = new Case(new Point(i,j));
            }
        }
    }

    public void placerPions(int joueur, int colonne){
        for (int i = this.grille.length-1; i >= 0; i--) {
            if(grille[i][colonne].getSymbole().equals(" ")){
                switch (joueur) {
                    case 1 -> grille[i][colonne].setSymbole("1");
                    case 2 -> grille[i][colonne].setSymbole("2");
                }
                break;
            }
        }
    }

    public boolean checkColonneFull(int colonne){

        if(!grille[0][colonne].getSymbole().equals(" ")){
            System.out.println("Colonne Pleine!");
            return true;
        }
        return false;

    }

    public boolean outOfBounds(int colonne){
        if(colonne < 0 || colonne > grille[0].length){
            if(colonne == 999){
                return false;
            }
            System.out.println("Colonne Out of Bound!\n");
            return false;
        }

        return true;
    }

    public boolean checkNumber(String colonne){
        if(colonne.equals("1") || colonne.equals("2") || colonne.equals("3") || colonne.equals("4") || colonne.equals("5") || colonne.equals("6") || colonne.equals("0")){
            return true;
        }
        return false;
    }

    public boolean checkVictory(int player){
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {

                if(checkRow(i,j, player)){
                    System.out.println("VICTOIRE");
                    return true;
                }
                if(checkColumn(i,j, player)){
                    System.out.println("VICTOIRE");
                    return true;
                }
                if(checkDiagonaleGauche(i,j,player)){
                    System.out.println("VICTOIRE");
                    return true;
                }

                if(checkDiagonaleDroite(i,j,player)){
                    System.out.println("VICTOIRE");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkRow(int i, int j, int player){
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

    public boolean checkColumn(int i, int j, int player){
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

    public boolean checkDiagonaleGauche(int i, int j, int player){
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

    public boolean checkDiagonaleDroite(int i, int j, int player){
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

    public boolean checkFull(){
        for (int j = 0; j < grille[0].length; j++) {
            if(grille[0][j].getSymbole().equals(" ")){
                return false;
            }
        }
        return true;
    }

    public Case[][] getGrille() {
        return grille;
    }

    public void setGrille(Case[][] grille) {
        this.grille = grille;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
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
