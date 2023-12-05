package ex1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Compte {
    private double solde;
    int c  ;
    private Lock verrou = new ReentrantLock();  // Utilisé pour éviter les problèmes de concurrence

    public Compte(double solde ) {
        this.solde = solde;
        this.c=0;
    }

    public void ajouter(double montant) {
        verrou.lock();
        try {
            solde += montant;
        } finally {
            verrou.unlock();
        }
    }

    public void retirer(double montant) {
        verrou.lock();
        try {
            if (solde >= montant) {
                solde -= montant;
            } else {
                System.out.println("Solde insuffisant.");
            }
        } finally {
            verrou.unlock();
        }
    }

    public double getSolde() {
        verrou.lock();
        try {
            return solde;
        } finally {
            verrou.unlock();
        }
    }
}
