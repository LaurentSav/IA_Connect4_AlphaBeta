import Environment.Environment;
import Noeud.Heuristic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Initialisation de l'environnement
        Environment env = new Environment(6);

        // Joueur Humain
        int joueur = 1;
        // Agent
        int previousjoueur = 2;

        // Methode heuristique 1 ou 2
        Heuristic.methode = 2;

        System.out.println(env);

        // Tant que la grille n'est pas pleine ou qu'il n'y a pas de joueur vainqueur
        while (!env.checkFull() && !env.checkVictory(previousjoueur)){
            // Tour du Joueur Humain
            if(joueur == 1){
                int reponse = 999;
                while(!env.outOfBounds(reponse)){
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Choisir colonne :");
                    String nextline = sc.nextLine();
                    if(env.checkNumber(nextline)){
                        reponse = Integer.parseInt(nextline);
                        if(env.checkColonneFull(reponse)){
                            reponse = 999;
                            System.out.println(env);
                        }
                    }else{
                        System.out.println("Mauvais Input");
                        System.out.println(env);
                    }
                }
                env.placerPions(joueur, reponse);
            }else{
                // Tour de l'agent
                env.getAgent().chooseAction(env);
            }

            System.out.println(env);

            // Changement du joueur courant
            if(joueur == 1){
                joueur = 2;
                previousjoueur = 1;
            }else{
                joueur = 1;
                previousjoueur = 2;
            }
        }
    }
}
