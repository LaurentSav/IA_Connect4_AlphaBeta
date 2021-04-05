package Agent;

public class Coup {
    private int eval;
    private int colonne;

    public Coup(int eval, int colonne) {
        this.eval = eval;
        this.colonne = colonne;
    }

    public int getEval() {
        return this.eval;
    }

    public int getColonne() {
        return this.colonne;
    }

}