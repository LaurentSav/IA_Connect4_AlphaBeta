package Agent;

import Environment.Case;
import Environment.Environment;
import Noeud.Noeud;

public class Agent {

    private Capteur capteur;
    private Effecteur effecteur;
    private Case[][] beliefs;

    // Profondeur de l'arbre de recherche
    private int profondeur;

    public Agent(int profondeur){
        capteur = new Capteur();
        effecteur = new Effecteur();
        beliefs = capteur.initialisationGrille();
        this.profondeur = profondeur;
    }

    // Observation de la grille
    public void observerGrille(Environment env){
        beliefs = capteur.observerGrille(env, beliefs);
    }

    // Choix de la prochaine action de l'agent
    public void chooseAction(Environment env){

        //Mise a jour des croyances
        observerGrille(env);

        //Choix du prochain coup
        Noeud n = new Noeud(true, beliefs);
        AlphaBeta ab = new AlphaBeta();
        // Alpha = +Infini et Beta = -Infini
        Coup c = ab.AlphaBeta(n, Integer.MIN_VALUE, Integer.MAX_VALUE, this.profondeur);

        // Affichage du score de la colonne choisi
        System.out.println(c.getEval());
        //Execution du coup de l'IA
        effecteur.doIt(c.getColonne(), env);

    }


    /*
    * Affichage des croyances de l'agent
     */
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
