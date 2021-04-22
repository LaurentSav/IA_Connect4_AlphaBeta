package Agent;

import Environment.Case;
import Environment.Environment;
import Noeud.Noeud;

public class Agent {

    private Capteur capteur;
    private Effecteur effecteur;
    private Case[][] beliefs;

    private int profondeur;

    public Agent(int profondeur){
        capteur = new Capteur();
        effecteur = new Effecteur();
        beliefs = capteur.initialisationGrille();
        this.profondeur = profondeur;
    }

    public void observerGrille(Environment env){
        beliefs = capteur.observerGrille(env, beliefs);
    }

    public void chooseAction(Environment env){

        //Mise a jour des croyances
        observerGrille(env);

        //Choix du prochain coup
        Noeud n = new Noeud(true, beliefs);
        AlphaBeta ab = new AlphaBeta();
        Coup c = ab.AlphaBeta(n, Integer.MIN_VALUE, Integer.MAX_VALUE, this.profondeur);
        //Execution du coup de l'IA
        System.out.println(c.getEval());
        effecteur.doIt(c.getColonne(), env);

    }



    @Override
    public String toString() {
        System.out.println("Croyance de l'agent");
        String affichage = "";
        for (int i = 0; i < beliefs.length; i++) {
            for (int j = 0; j < beliefs[i].length; j++) {
                affichage += beliefs[i][j].toString();
            }
            affichage += "\n";
        }

        for (int i = 0; i < beliefs[0].length; i++) {
            affichage += " " + i + " ";
        }
        affichage += "\n";

        return affichage;
    }









}
