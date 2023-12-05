package ex2;


import java.util.concurrent.Semaphore;

class Usine {
    private Semaphore ressources;

    public Usine(int nombreRessources) {
        this.ressources = new Semaphore(nombreRessources, true);
    }

    public void assemblerProduit(int travailleurId) {
        try {
            ressources.acquire();
            System.out.println("Ouvrier " + travailleurId + " commence l'assemblage.");
            Thread.sleep(10000); // Temps d'assemblage simulé de 10 secondes
            System.out.println("Ouvrier " + travailleurId + " a terminé l'assemblage.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            ressources.release();
        }
    }
}
