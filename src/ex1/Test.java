package ex1;

public class Test {
    public static void main(String[] args) {
        Compte compte = new Compte(0);

        Operation[] operations = {
                new Operation(compte, 'A', 100),
                new Operation(compte, 'R', 50),
                new Operation(compte, 'A', 30),
                new Operation(compte, 'R', 20)
        };

        for (Operation operation : operations) {
            operation.start();
        }

        for (Operation operation : operations) {
            try {
                operation.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Solde final du compte: " + compte.getSolde());
    }
}

