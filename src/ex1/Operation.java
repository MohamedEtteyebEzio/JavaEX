package ex1;

class Operation extends Thread {
    private Compte compte;
    private char typeOperation;
    private double montant;


    public Operation(Compte compte, char typeOperation, double montant) {
        this.compte = compte;
        this.typeOperation = typeOperation;
        this.montant = montant;
    }


    @Override
    public void run() {
        if (compte.c<20) {
            if (typeOperation == 'A') {
                compte.ajouter(montant);
                compte.c++;
            } else if (typeOperation == 'R') {
                compte.retirer(montant);
                compte.c++;
            }
        }
        else
            System.out.println("vous avez depassé le nombre d'operation possible");
        }
}
