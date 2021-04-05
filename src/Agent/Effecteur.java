package Agent;

import Environment.Environment;

public class Effecteur {

    public void doIt(int column, Environment env){
        env.placerPions(2, column);
    }


}
