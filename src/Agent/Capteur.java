package Agent;

import Environment.Case;
import Environment.Environment;

import java.awt.*;

public class Capteur {



    public Case[][] initialisationGrille(){
        Case[][] grille = new Case[6][7];
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                grille[i][j] = new Case(new Point(i,j));
            }
        }
        return grille;
    }

    public Case[][] observerGrille(Environment env, Case[][] grille){
        for (int i = 0; i < env.getGrille().length; i++) {
            for (int j = 0; j < env.getGrille()[0].length; j++) {
                grille[i][j].setSymbole(env.getGrille()[i][j].getSymbole());
                grille[i][j].setP(env.getGrille()[i][j].getP());
            }
        }
        return grille;
    }

}
