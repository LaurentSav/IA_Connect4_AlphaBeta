import Environment.Environment;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Environment env = new Environment(6);
        int joueur = 1;
        int previousjoueur = 2;
        System.out.println(env);

        while (!env.checkFull() && !env.checkVictory(previousjoueur)){
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
                env.getAgent().chooseAction(env);
            }

            System.out.println(env);

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
