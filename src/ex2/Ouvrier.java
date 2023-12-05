package ex2;


class Ouvrier extends Thread {
    private Usine usine;
    private int ouvrierId;

    public Ouvrier(Usine usine, int ouvrierId) {
        this.usine = usine;
        this.ouvrierId = ouvrierId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            usine.assemblerProduit(ouvrierId);
        }
    }
}
