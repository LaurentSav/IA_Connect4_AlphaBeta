package Agent;

import Environment.Environment;

public class Effecteur {

    /* Placer un pion */
    public void doIt(int column, Environment env){
        env.placerPions(2, column);
    }


}
