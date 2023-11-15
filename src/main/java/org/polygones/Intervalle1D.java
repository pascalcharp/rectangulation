package org.polygones;

public class Intervalle1D {
    public double debut ;
    public double fin ;

    public Intervalle1D(double debutInit, double finInit) {
        debut = debutInit ;
        fin = finInit ;
    }

    public Intervalle1D(AreteHorizontale a) {
        debut = a.debut() ;
        fin = a.fin() ;
    }
}
