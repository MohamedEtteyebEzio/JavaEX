package ex2;


public class TestUsine {
    public static void main(String[] args) {
        Usine usine = new Usine(3); // Nombre de ressources disponibles dans l'usine

        Ouvrier ouvrier1 = new Ouvrier(usine, 1);
        Ouvrier ouvrier2 = new Ouvrier(usine, 2);
        Ouvrier ouvrier3 = new Ouvrier(usine, 3);

        ouvrier1.start();
        ouvrier2.start();
        ouvrier3.start();

        try {
            ouvrier1.join();
            ouvrier2.join();
            ouvrier3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
